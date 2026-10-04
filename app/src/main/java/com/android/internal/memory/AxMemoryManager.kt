/*
 * Copyright (C) 2025-2026 The Infinity-X Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.internal.memory

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.Settings
import android.telecom.TelecomManager

// trims cached/background processes GameSpace is actually allowed to kill
object AxMemoryManager {

    private val systemCriticalPackages = setOf(
        "android",
        "com.android.systemui",
        "com.android.providers.telephony",
        "com.android.server.telecom",
        "com.android.providers.media",
        "com.android.providers.media.module",
        "com.android.bluetooth",
        "com.android.nfc",
    )

    /** Returns the MB of RAM freed (best-effort measurement), or -1 on failure. */
    fun releaseMemory(context: Context): Long {
        val am = context.getSystemService(Context.ACTIVITY_SERVICE) as? ActivityManager
            ?: return -1L
        val before = ActivityManager.MemoryInfo().also { am.getMemoryInfo(it) }.availMem

        val excluded = systemCriticalPackages.toMutableSet().apply {
            launcherPackage(context)?.let { add(it) }
            activeImePackage(context)?.let { add(it) }
            defaultDialerPackage(context)?.let { add(it) }
            add(context.packageName)
        }

        try {
            am.runningAppProcesses?.forEach { proc ->
                proc.pkgList?.forEach { pkg ->
                    if (pkg !in excluded) {
                        try {
                            am.killBackgroundProcesses(pkg)
                        } catch (_: SecurityException) {
                            // best-effort: some packages refuse a kill, that's fine
                        }
                    }
                }
            }
        } catch (_: Exception) {
            return -1L
        }

        val after = ActivityManager.MemoryInfo().also { am.getMemoryInfo(it) }.availMem
        return (after - before) / (1024 * 1024)
    }

    private fun launcherPackage(context: Context): String? {
        val intent = Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME)
        return context.packageManager
            .resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)
            ?.activityInfo?.packageName
    }

    private fun activeImePackage(context: Context): String? {
        val active = Settings.Secure.getString(
            context.contentResolver, Settings.Secure.DEFAULT_INPUT_METHOD
        )
        return active?.substringBefore("/")
    }

    private fun defaultDialerPackage(context: Context): String? =
        (context.getSystemService(Context.TELECOM_SERVICE) as? TelecomManager)
            ?.defaultDialerPackage
}

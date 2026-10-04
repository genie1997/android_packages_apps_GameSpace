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
package com.android.axion.platform

import android.os.Bundle

// wraps the Bundle shape AxPlatformClient.getState()/onStateChanged() actually carry
class AxFeatureState(private val bundle: Bundle) {
    val isEmpty: Boolean get() = bundle.isEmpty

    val isActive: Boolean
        get() = bundle.getBoolean("active", bundle.getBoolean("enabled", false))

    val label: String?
        get() = bundle.getString("label")

    companion object {
        val EMPTY = AxFeatureState(Bundle.EMPTY)
    }
}

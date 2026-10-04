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

// aliases onto AxPlatformClient's own FEATURE_* constants, never a separate value
object AxPlatformFeature {
    val WIFI = AxPlatformClient.FEATURE_WIFI
    val MOBILE_DATA = AxPlatformClient.FEATURE_MOBILE_DATA
    val BLUETOOTH = AxPlatformClient.FEATURE_BLUETOOTH
    val HOTSPOT = AxPlatformClient.FEATURE_HOTSPOT
    val FLASHLIGHT = AxPlatformClient.FEATURE_FLASHLIGHT
    val LOCATION = AxPlatformClient.FEATURE_LOCATION
    val ROTATION = AxPlatformClient.FEATURE_ROTATION
    val BATTERY_SAVER = AxPlatformClient.FEATURE_BATTERY_SAVER
    val ZEN = AxPlatformClient.FEATURE_ZEN
    val AOD = AxPlatformClient.FEATURE_AOD
    val DATA_SAVER = AxPlatformClient.FEATURE_DATA_SAVER
    val AIRPLANE_MODE = AxPlatformClient.FEATURE_AIRPLANE_MODE
    val NFC = AxPlatformClient.FEATURE_NFC
    val DARK_MODE = AxPlatformClient.FEATURE_DARK_MODE
    val NIGHT_LIGHT = AxPlatformClient.FEATURE_NIGHT_LIGHT
    val COLOR_INVERSION = AxPlatformClient.FEATURE_COLOR_INVERSION
    val COLOR_CORRECTION = AxPlatformClient.FEATURE_COLOR_CORRECTION
    val REDUCE_BRIGHTNESS = AxPlatformClient.FEATURE_REDUCE_BRIGHTNESS
    val ONE_HANDED_MODE = AxPlatformClient.FEATURE_ONE_HANDED_MODE
    val HEADS_UP = AxPlatformClient.FEATURE_HEADS_UP
    val AUTO_SYNC = AxPlatformClient.FEATURE_AUTO_SYNC
    val CAMERA_PRIVACY = AxPlatformClient.FEATURE_CAMERA_PRIVACY
    val MIC_PRIVACY = AxPlatformClient.FEATURE_MIC_PRIVACY
    val WORK_PROFILE = AxPlatformClient.FEATURE_WORK_PROFILE
    val USB_TETHER = AxPlatformClient.FEATURE_USB_TETHER
    val DREAM = AxPlatformClient.FEATURE_DREAM
    val READING_MODE = AxPlatformClient.FEATURE_READING_MODE
    val POWER_SHARE = AxPlatformClient.FEATURE_POWER_SHARE
    val CAFFEINE = AxPlatformClient.FEATURE_CAFFEINE
    val VPN = AxPlatformClient.FEATURE_VPN
    val CAST = AxPlatformClient.FEATURE_CAST
    val PROFILES = AxPlatformClient.FEATURE_PROFILES
    val SMART_PIXELS = AxPlatformClient.FEATURE_SMART_PIXELS
    val SCREEN_RECORD = AxPlatformClient.FEATURE_SCREEN_RECORD
    val SCREENSHOT = AxPlatformClient.FEATURE_SCREENSHOT
}

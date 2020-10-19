package com.vbytsyuk.android.storage

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit


class SharedPreferenceThemeStorage(private val context: Context) : ThemeStorage {
    private val storage: SharedPreferences
        get() = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    override var themeCode: Int
        get() = storage.getInt(THEME_KEY, -1)
        set(newThemeCode) = storage.edit { putInt(THEME_KEY, newThemeCode) }

    companion object {
        const val SHARED_PREFERENCES_NAME = "com.vbytsyuk.android.storage.SharedPreferenceThemeStorage"
        const val THEME_KEY = "com.vbytsyuk.android.storage.THEME"
    }
}

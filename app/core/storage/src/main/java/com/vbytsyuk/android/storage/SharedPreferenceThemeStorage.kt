package com.vbytsyuk.android.storage

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.vbytsyuk.android.core.Theme
import com.vbytsyuk.android.core.storage.ThemeStorage


class SharedPreferenceThemeStorage(private val context: Context) : ThemeStorage {
    private val storage: SharedPreferences
        get() = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    override var theme: Theme
        get() = Theme.fromCode(code = storage.getInt(THEME_KEY, Theme.LIGHT.code))
        set(newTheme) = storage.edit { putInt(THEME_KEY, newTheme.code) }

    companion object {
        const val SHARED_PREFERENCES_NAME = "com.vbytsyuk.android.storage.SharedPreferenceThemeStorage"
        const val THEME_KEY = "com.vbytsyuk.android.storage.THEME"
    }
}

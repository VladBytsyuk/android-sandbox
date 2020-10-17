package com.vbytsyuk.android.core.controllers

import com.vbytsyuk.android.core.Theme
import com.vbytsyuk.android.storage.ThemeStorage


class ThemeController(private val themeStorage: ThemeStorage) {
    val currentTheme: Theme = Theme.fromCode(themeStorage.themeCode)

    fun setTheme(newTheme: Theme) {
        themeStorage.themeCode = newTheme.code
    }
}

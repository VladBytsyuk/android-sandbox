package com.vbytsyuk.android.core.activity

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vbytsyuk.android.core.R
import com.vbytsyuk.android.core.Theme
import com.vbytsyuk.android.core.controllers.ThemeController
import org.koin.android.ext.android.inject


abstract class ThemedActivity : AppCompatActivity() {
    protected val themeController: ThemeController by inject()

    protected fun configureTheme(theme: Theme) {
        themeController.setTheme(theme)
        recreate()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(currentThemeRes)
        super.onCreate(savedInstanceState)
    }

    private val systemTheme: Theme get() = when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
        Configuration.UI_MODE_NIGHT_YES -> Theme.DARK
        Configuration.UI_MODE_NIGHT_NO -> Theme.LIGHT
        else -> Theme.LIGHT
    }

    private val currentThemeRes: Int get() = when (val theme = themeController.currentTheme) {
        Theme.BY_SYSTEM -> getConcreteThemeRes(systemTheme)
        else -> getConcreteThemeRes(theme)
    }

    private fun getConcreteThemeRes(theme: Theme): Int = when (theme) {
        Theme.BY_SYSTEM -> throw IllegalArgumentException("This method can not return ${Theme.BY_SYSTEM}")
        Theme.LIGHT -> R.style.Theme_Sandbox_Light_NoActionBar
        Theme.DARK -> R.style.Theme_Sandbox_Dark_NoActionBar
    }


    private var currentTheme: Theme = themeController.currentTheme

    override fun onResume() {
        super.onResume()
        if (currentTheme != themeController.currentTheme) recreate()
    }

    override fun onPause() {
        currentTheme = themeController.currentTheme
        super.onPause()
    }
}

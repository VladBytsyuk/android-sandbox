package com.vbytsyuk.android.core.activity

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

    private val currentThemeRes: Int get () = when (themeController.currentTheme) {
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

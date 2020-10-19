package com.vbytsyuk.android.core.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.vbytsyuk.android.core.R
import com.vbytsyuk.android.core.Theme
import com.vbytsyuk.android.core.appbar.AppBarConfigurator
import com.vbytsyuk.android.core.controllers.ThemeController
import org.koin.android.ext.android.inject


abstract class CoreActivity(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity() {
    open val appBarConfigurator: AppBarConfigurator? = null
    protected val themeController: ThemeController by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        val theme = when (themeController.currentTheme) {
            Theme.LIGHT -> R.style.Theme_Sandbox_Light_NoActionBar
            Theme.DARK -> R.style.Theme_Sandbox_Dark_NoActionBar
        }
        setTheme(theme)
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        appBarConfigurator?.configure(this)
        setClickListeners()
    }

    override fun onResume() {
        super.onResume()
        if (currentTheme != themeController.currentTheme) recreate()
    }

    private var currentTheme: Theme = themeController.currentTheme
    override fun onPause() {
        currentTheme = themeController.currentTheme
        super.onPause()
    }

    protected fun configureTheme(isDark: Boolean) {
        themeController.setTheme(if (isDark) Theme.DARK else Theme.LIGHT)
        recreate()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean =
        appBarConfigurator?.inflateMenu(menuInflater, menu) ?: super.onCreateOptionsMenu(menu)

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val toggleButtons = appBarConfigurator?.buttons?.filterIsInstance<AppBarConfigurator.Button.Toggle>()
        if (toggleButtons != null && menu != null) {
            toggleButtons
                .mapNotNull { toggleButton -> findMenuItemForButton(menu, toggleButton)?.let { it to toggleButton } }
                .forEach { (menuItem, button) ->
                    checkToggleButton(menuItem, button, isChecked = button.isChecked, forceClickListener = false)
                }
        }
        return super.onPrepareOptionsMenu(menu)
    }

    private fun findMenuItemForButton(menu: Menu, button: AppBarConfigurator.Button): MenuItem? =
        menu.children.find { it.itemId == button.menuItemId }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val button: AppBarConfigurator.Button = appBarConfigurator?.buttons?.find { it.menuItemId == item.itemId }
            ?: return super.onOptionsItemSelected(item)
        when (button) {
            is AppBarConfigurator.Button.Simple -> button.clickListener()
            is AppBarConfigurator.Button.Toggle ->
                checkToggleButton(item, button, isChecked = !button.isChecked, forceClickListener = true)
        }
        return true
    }

    private fun checkToggleButton(
        menuItem: MenuItem,
        toggleButton: AppBarConfigurator.Button.Toggle,
        isChecked: Boolean,
        forceClickListener: Boolean
    ) {
        menuItem.setIcon(if (isChecked) toggleButton.checkedIconId else toggleButton.normalIconId)
        toggleButton.isChecked = isChecked
        if (forceClickListener) toggleButton.clickListener(isChecked)
    }

    abstract fun setClickListeners()
}

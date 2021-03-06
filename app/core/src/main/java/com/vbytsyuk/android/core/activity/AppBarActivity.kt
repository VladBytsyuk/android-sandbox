package com.vbytsyuk.android.core.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.annotation.StyleRes
import androidx.core.view.children
import com.vbytsyuk.android.core.appbar.AppBarConfigurator


abstract class AppBarActivity(
    @LayoutRes layoutId: Int,
    @StyleRes themeLight: Int,
    @StyleRes themeDark: Int
) : LayoutActivity(layoutId, themeLight, themeDark) {
    open val appBarConfigurator: AppBarConfigurator? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appBarConfigurator?.configure(this)
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
}

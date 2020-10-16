package com.vbytsyuk.android.core.appbar

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.vbytsyuk.android.core.appbar.AppBarConfigurator.*


class ToolBarConfigurator(
    @IdRes private val toolbarId: Int,
    @StringRes private val titleId: Int? = null,
    private val leftButton: LeftButton? = null,
    private val buttonsMenu: ButtonsMenu? = null
) : AppBarConfigurator {
    override fun configure(activity: AppCompatActivity) = with(activity) {
        val toolbar: Toolbar = findViewById(toolbarId) ?: return@with
        setSupportActionBar(toolbar)
        if (titleId != null) setTitle(titleId)
        if (leftButton != null) {
            toolbar.setNavigationIcon(leftButton.iconId)
            toolbar.setNavigationOnClickListener { leftButton.clickListener() }
        }
    }

    override fun inflateMenu(inflater: MenuInflater, menu: Menu?): Boolean {
        if (buttonsMenu == null) return false
        inflater.inflate(buttonsMenu.menuId, menu)
        return true
    }

    override val menuMap: List<Button>? get() = buttonsMenu?.map
}

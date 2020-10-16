package com.vbytsyuk.android.core.appbar

import android.view.Menu
import android.view.MenuInflater
import androidx.annotation.DrawableRes
import androidx.annotation.MenuRes
import androidx.appcompat.app.AppCompatActivity


interface AppBarConfigurator {
    fun configure(activity: AppCompatActivity)
    fun inflateMenu(inflater: MenuInflater, menu: Menu?): Boolean
    val menuMap: List<Button>?


    data class LeftButton(@DrawableRes val iconId: Int, val clickListener: () -> Unit)
    data class ButtonsMenu(@MenuRes val menuId: Int, val map: List<Button>)

    sealed class Button(open val menuItemId: Int) {
        data class Simple(
            override val menuItemId: Int,
            @DrawableRes val iconId: Int,
            val clickListener: () -> Unit
        ) : Button(menuItemId)

        data class Toggl(
            override val menuItemId: Int,
            var isChecked: Boolean = false,
            @DrawableRes val normalIconId: Int,
            @DrawableRes val checkedIconId: Int,
            val clickListener: (Boolean) -> Unit
        ) : Button(menuItemId)
    }
}

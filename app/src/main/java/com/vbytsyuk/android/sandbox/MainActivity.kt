package com.vbytsyuk.android.sandbox

import android.widget.Button
import com.vbytsyuk.android.core.Theme
import com.vbytsyuk.android.core.appbar.ToolBarConfigurator
import com.vbytsyuk.android.core.activity.CoreActivity
import com.vbytsyuk.android.core.activity.lazyFindViewById
import com.vbytsyuk.android.core.activity.navigateTo
import com.vbytsyuk.android.core.appbar.AppBarConfigurator
import com.vbytsyuk.android.layout.ChooseLayoutActivity
import com.vbytsyuk.android.lifecycle.ChooseLifecycleActivity
import com.vbytsyuk.android.pictures.screen.PictureScreenActivity


class MainActivity : CoreActivity(
    layoutId = R.layout.activity_main,
    themeLight = R.style.Theme_Sandbox_Light_NoActionBar,
    themeDark = R.style.Theme_Sandbox_Dark_NoActionBar
) {
    private val buttonImageLoaders: Button by lazyFindViewById(R.id.amBtnPictureLoaders)
    private val buttonReactive: Button by lazyFindViewById(R.id.amBtnReactive)
    private val buttonLifecycle: Button by lazyFindViewById(R.id.amBtnLifeCycle)
    private val buttonLayout: Button by lazyFindViewById(R.id.amBtnLayout)

    override val appBarConfigurator = ToolBarConfigurator(
        toolbarId = R.id.amToolbar,
        titleId = R.string.app_name,
        buttonsMenu = AppBarConfigurator.ButtonsMenu(
            menuId = R.menu.menu_appbar_default,
            buttons = listOf(
                AppBarConfigurator.Button.Toggle(
                    menuItemId = R.id.abmiTheme,
                    isChecked = themeController.currentTheme == Theme.DARK,
                    normalIconId = R.drawable.ic_day,
                    checkedIconId = R.drawable.ic_night,
                    clickListener = { configureTheme(if (it) Theme.DARK else Theme.LIGHT) }
                )
            )
        )
    )

    override fun setClickListeners() {
        buttonImageLoaders.setOnClickListener { navigateTo<PictureScreenActivity>() }
        buttonLifecycle.setOnClickListener { navigateTo<ChooseLifecycleActivity>() }
        buttonLayout.setOnClickListener { navigateTo<ChooseLayoutActivity>() }
    }
}

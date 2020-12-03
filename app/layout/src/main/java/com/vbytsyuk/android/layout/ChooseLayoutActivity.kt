package com.vbytsyuk.android.layout

import android.widget.Button
import com.vbytsyuk.android.core.activity.CoreActivity
import com.vbytsyuk.android.core.activity.lazyFindViewById
import com.vbytsyuk.android.core.activity.navigateTo
import com.vbytsyuk.android.core.appbar.AppBarConfigurator
import com.vbytsyuk.android.core.appbar.ToolBarConfigurator

//https://www.figma.com/file/EYV3UeSa7vnjWEr8txbol5YV/App-cart-templates-ecommerce/duplicate
class ChooseLayoutActivity : CoreActivity(
    layoutId = R.layout.activity_choose_layout,
    themeLight = R.style.Theme_Sandbox_Light_NoActionBar,
    themeDark = R.style.Theme_Sandbox_Dark_NoActionBar
) {
    private val buttonClassicLayout: Button by lazyFindViewById(R.id.aclBtnClassicLayout)
    private val buttonConstraintLayout: Button by lazyFindViewById(R.id.aclBtnConstraintLayout)
    private val buttonComposeLayout: Button by lazyFindViewById(R.id.aclBtnComposeLayout)

    override val appBarConfigurator = ToolBarConfigurator(
        toolbarId = R.id.aclayToolbar,
        titleId = R.string.aclay_title,
        leftButton = AppBarConfigurator.LeftButton(R.drawable.ic_arrow_back) { finish() }
    )

    override fun setClickListeners() {
        buttonClassicLayout.setOnClickListener { navigateTo<ClassicLayoutActivity>() }
        buttonConstraintLayout.setOnClickListener { navigateTo<ConstraintLayoutActivity>() }
        buttonComposeLayout.setOnClickListener { navigateTo<ComposeLayoutActivity>() }
    }
}

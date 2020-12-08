package com.vbytsyuk.android.reactive

import android.widget.Button
import com.vbytsyuk.android.core.activity.CoreActivity
import com.vbytsyuk.android.core.activity.lazyFindViewById
import com.vbytsyuk.android.core.appbar.AppBarConfigurator
import com.vbytsyuk.android.core.appbar.ToolBarConfigurator


class ChooseLibraryActivity : CoreActivity(
    layoutId = R.layout.activity_choose_library,
    themeLight = R.style.Theme_Sandbox_Light_NoActionBar,
    themeDark = R.style.Theme_Sandbox_Dark_NoActionBar
) {
    private val buttonRxJava: Button by lazyFindViewById(R.id.aclBtnRxJava)
    private val buttonKotlinFlow: Button by lazyFindViewById(R.id.aclBtnFlow)

    override val appBarConfigurator = ToolBarConfigurator(
        toolbarId = R.id.aclibToolbar,
        titleId = R.string.aclib_title,
        leftButton = AppBarConfigurator.LeftButton(R.drawable.ic_arrow_back) { finish() }
    )

    override fun setClickListeners() {
        buttonRxJava.setOnClickListener {  }
        buttonKotlinFlow.setOnClickListener {  }
    }
}

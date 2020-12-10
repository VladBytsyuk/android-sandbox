package com.vbytsyuk.android.rxjava

import com.vbytsyuk.android.core.activity.CoreActivity
import com.vbytsyuk.android.core.appbar.AppBarConfigurator
import com.vbytsyuk.android.core.appbar.ToolBarConfigurator


class RxJavaActivity : CoreActivity(
    layoutId = R.layout.activity_rx_java,
    themeLight = R.style.Theme_Sandbox_Light_NoActionBar,
    themeDark = R.style.Theme_Sandbox_Dark_NoActionBar
) {
    override val appBarConfigurator = ToolBarConfigurator(
        toolbarId = R.id.arjToolbar,
        titleId = R.string.arj_title,
        leftButton = AppBarConfigurator.LeftButton(R.drawable.ic_arrow_back) { finish() }
    )

    override fun setClickListeners() {
        TODO("Not yet implemented")
    }
}

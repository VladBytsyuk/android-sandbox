package com.vbytsyuk.android.lifecycle

import android.widget.Button
import com.vbytsyuk.android.core.activity.CoreActivity
import com.vbytsyuk.android.core.activity.lazyFindViewById
import com.vbytsyuk.android.core.activity.navigateTo
import com.vbytsyuk.android.core.appbar.AppBarConfigurator
import com.vbytsyuk.android.core.appbar.ToolBarConfigurator


class ChooseLifecycleActivity : CoreActivity(
    layoutId = R.layout.activity_choose_lifecycle,
    themeLight = R.style.Theme_Sandbox_Light_NoActionBar,
    themeDark = R.style.Theme_Sandbox_Dark_NoActionBar
) {
    private val buttonSimpleActivity: Button by lazyFindViewById(R.id.aclBtnSimpleActivity)
    private val buttonJetpackActivity: Button by lazyFindViewById(R.id.aclBtnJetpackActivity)

    override val appBarConfigurator = ToolBarConfigurator(
        toolbarId = R.id.aclToolbar,
        titleId = R.string.acl_title,
        leftButton = AppBarConfigurator.LeftButton(R.drawable.ic_arrow_back) { finish() }
    )

    override fun setClickListeners() {
        buttonSimpleActivity.setOnClickListener { navigateTo<SimpleActivity>() }
        buttonJetpackActivity.setOnClickListener { navigateTo<JetpackActivity>() }
    }
}
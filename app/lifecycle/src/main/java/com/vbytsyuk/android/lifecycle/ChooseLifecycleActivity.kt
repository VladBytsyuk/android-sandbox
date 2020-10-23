package com.vbytsyuk.android.lifecycle

import android.widget.Button
import com.vbytsyuk.android.core.activity.CoreActivity
import com.vbytsyuk.android.core.activity.lazyFindViewById
import com.vbytsyuk.android.core.activity.navigateTo
import com.vbytsyuk.android.core.appbar.AppBarConfigurator
import com.vbytsyuk.android.core.appbar.ToolBarConfigurator


class ChooseLifecycleActivity : CoreActivity(layoutId = R.layout.activity_choose_lifecycle) {
    private val buttonSimpleActivity: Button by lazyFindViewById(R.id.aclBtnSimpleActivity)

    override val appBarConfigurator = ToolBarConfigurator(
        toolbarId = R.id.aclToolbar,
        titleId = R.string.acl_title,
        leftButton = AppBarConfigurator.LeftButton(R.drawable.ic_arrow_back) { finish() }
    )

    override fun setClickListeners() {
        buttonSimpleActivity.setOnClickListener { navigateTo<SimpleActivity>() }
    }
}
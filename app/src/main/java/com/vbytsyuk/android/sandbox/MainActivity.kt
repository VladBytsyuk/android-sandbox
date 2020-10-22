package com.vbytsyuk.android.sandbox

import android.widget.Button
import com.vbytsyuk.android.core.appbar.ToolBarConfigurator
import com.vbytsyuk.android.core.activity.CoreActivity
import com.vbytsyuk.android.core.activity.lazyFindViewById
import com.vbytsyuk.android.core.activity.navigateTo
import com.vbytsyuk.android.core.appbar.AppBarConfigurator
import com.vbytsyuk.android.lifecycle.ChooseLifecycleActivity
import com.vbytsyuk.android.pictures.screen.PictureScreenActivity


class MainActivity : CoreActivity(layoutId = R.layout.activity_main) {
    private val buttonImageLoaders: Button by lazyFindViewById(R.id.amBtnPictureLoaders)
    private val buttonLifecycle: Button by lazyFindViewById(R.id.amBtnLifeCycle)

    override val appBarConfigurator = ToolBarConfigurator(
        toolbarId = R.id.amToolbar,
        titleId = R.string.app_name
    )

    override fun setClickListeners() {
        buttonImageLoaders.setOnClickListener { navigateTo<PictureScreenActivity>() }
        buttonLifecycle.setOnClickListener { navigateTo<ChooseLifecycleActivity>() }
    }
}

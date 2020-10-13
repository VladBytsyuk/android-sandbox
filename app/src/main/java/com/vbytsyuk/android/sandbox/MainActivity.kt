package com.vbytsyuk.android.sandbox

import android.widget.Button
import com.vbytsyuk.android.core.activity.CoreActivity
import com.vbytsyuk.android.core.activity.lazyFindViewById
import com.vbytsyuk.android.core.activity.navigateTo
import com.vbytsyuk.android.pictures.screen.PictureScreenActivity


class MainActivity : CoreActivity(layoutId = R.layout.activity_main, titleId = R.string.app_name) {
    private val buttonImageLoaders: Button by lazyFindViewById(R.id.amBtnPictureLoaders)

    override fun setClickListeners() {
        buttonImageLoaders.setOnClickListener { navigateTo<PictureScreenActivity>() }
    }
}

package com.vbytsyuk.android.sandbox

import android.os.Bundle
import android.widget.Button
import com.vbytsyuk.android.core.activity.CoreActivity
import com.vbytsyuk.android.core.activity.lazyFindViewById
import com.vbytsyuk.android.core.activity.navigateTo
import com.vbytsyuk.android.glide.GlideActivity


class MainActivity : CoreActivity(layoutId = R.layout.activity_main) {
    private val buttonGlide: Button by lazyFindViewById(R.id.amBtnGlide)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buttonGlide.setOnClickListener { navigateTo<GlideActivity>() }
    }
}

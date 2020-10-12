package com.vbytsyuk.android.sandbox

import android.os.Bundle
import android.widget.Button
import com.vbytsyuk.android.core.activity.CoreActivity
import com.vbytsyuk.android.core.activity.navigateTo
import com.vbytsyuk.android.glide.GlideActivity


class MainActivity : CoreActivity(layoutId = R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<Button>(R.id.button).setOnClickListener { navigateTo<GlideActivity>() }
    }
}

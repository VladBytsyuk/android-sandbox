package com.vbytsyuk.android.core.activity

import android.os.Bundle
import androidx.annotation.LayoutRes


abstract class LayoutActivity(@LayoutRes private val layoutId: Int) : ThemedActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }
}

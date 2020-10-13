package com.vbytsyuk.android.core.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity


abstract class CoreActivity(
    @LayoutRes private val layoutId: Int,
    @StringRes private val titleId: Int? = null
) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        if (titleId != null) setTitle(titleId)
        setClickListeners()
    }

    abstract fun setClickListeners()
}

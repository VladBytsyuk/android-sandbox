package com.vbytsyuk.android.core.activity

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity


abstract class CoreActivity(
    @LayoutRes private val layoutId: Int,
    @StringRes private val titleId: Int? = null,
    @IdRes private val toolbarId: Int? = null
) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        if (toolbarId != null) setSupportActionBar(findViewById(toolbarId))
        if (titleId != null) setTitle(titleId)
        setClickListeners()
    }

    abstract fun setClickListeners()
}

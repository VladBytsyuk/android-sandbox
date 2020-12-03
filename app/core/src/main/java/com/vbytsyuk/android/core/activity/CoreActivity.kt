package com.vbytsyuk.android.core.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.StyleRes


abstract class CoreActivity(
    @LayoutRes layoutId: Int,
    @StyleRes themeLight: Int,
    @StyleRes themeDark: Int
) : AppBarActivity(layoutId, themeLight, themeDark) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setClickListeners()
    }

    abstract fun setClickListeners()
}

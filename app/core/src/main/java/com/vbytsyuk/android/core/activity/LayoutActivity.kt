package com.vbytsyuk.android.core.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.StyleRes
import com.vbytsyuk.android.core.R


abstract class LayoutActivity(
    @LayoutRes private val layoutId: Int,
    @StyleRes themeLight: Int,
    @StyleRes themeDark: Int
) : ThemedActivity(themeLight, themeDark) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }
}

package com.vbytsyuk.android.layout

import com.vbytsyuk.android.core.activity.CoreActivity


class ClassicLayoutActivity : CoreActivity(
    layoutId = R.layout.activity_classic_layout,
    themeLight = R.style.Theme_Layout_NoActionBar_Light,
    themeDark = R.style.Theme_Layout_NoActionBar_Dark
) {
    override fun setClickListeners() {
        /* do nothing */
    }
}

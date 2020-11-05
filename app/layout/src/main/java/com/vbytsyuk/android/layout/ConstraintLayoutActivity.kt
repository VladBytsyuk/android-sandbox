package com.vbytsyuk.android.layout

import com.vbytsyuk.android.core.activity.CoreActivity


class ConstraintLayoutActivity : CoreActivity(
    layoutId = R.layout.activity_constraint_layout,
    themeLight = R.style.Theme_Layout_NoActionBar_Light,
    themeDark = R.style.Theme_Layout_NoActionBar_Dark
) {
    override fun setClickListeners() {
        /* do nothing */
    }
}

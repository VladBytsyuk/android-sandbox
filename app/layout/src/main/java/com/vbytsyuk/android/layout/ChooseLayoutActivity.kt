package com.vbytsyuk.android.layout

import android.widget.Button
import com.vbytsyuk.android.core.activity.CoreActivity
import com.vbytsyuk.android.core.activity.lazyFindViewById
import com.vbytsyuk.android.core.activity.navigateTo

//https://www.figma.com/file/EYV3UeSa7vnjWEr8txbol5YV/App-cart-templates-ecommerce/duplicate
class ChooseLayoutActivity : CoreActivity(layoutId = R.layout.activity_choose_layout) {
    private val buttonClassicLayout: Button by lazyFindViewById(R.id.aclBtnClassicLayout)
    private val buttonConstraintLayout: Button by lazyFindViewById(R.id.aclBtnConstraintLayout)

    override fun setClickListeners() {
        buttonClassicLayout.setOnClickListener { navigateTo<ClassicLayoutActivity>() }
        buttonConstraintLayout.setOnClickListener { navigateTo<ConstraintLayoutActivity>() }
    }
}

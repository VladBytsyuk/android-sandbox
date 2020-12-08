package com.vbytsyuk.android.reactive

import android.widget.Button
import com.vbytsyuk.android.core.activity.CoreActivity
import com.vbytsyuk.android.core.activity.lazyFindViewById


class ChooseLibraryActivity : CoreActivity(
    layoutId = R.layout.activity_choose_library,
    themeLight = R.style.Theme_Sandbox_Light_NoActionBar,
    themeDark = R.style.Theme_Sandbox_Dark_NoActionBar
) {
    private val buttonClassicLayout: Button by lazyFindViewById(R.id.aclBtnRxJava)

    override fun setClickListeners() {
        TODO("Not yet implemented")
    }
}

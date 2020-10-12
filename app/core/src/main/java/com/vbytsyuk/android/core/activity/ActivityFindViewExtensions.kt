package com.vbytsyuk.android.core.activity

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes


inline fun <reified T : View> Activity.lazyFindViewById(@IdRes id: Int): Lazy<T> =
    lazy(mode = LazyThreadSafetyMode.NONE) { findViewById(id) }

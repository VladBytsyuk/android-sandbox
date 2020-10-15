package com.vbytsyuk.android.core.activity

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import com.vbytsyuk.android.core.nonThreadSafeLazy


inline fun <reified T : View> Activity.lazyFindViewById(@IdRes id: Int): Lazy<T> =
    nonThreadSafeLazy { findViewById(id) }

package com.vbytsyuk.android.core

import android.content.Context
import androidx.annotation.AttrRes
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.vbytsyuk.android.core.activity.color


fun Context.color(@ColorRes colorId: Int) =
    ContextCompat.getColor(this, colorId)

fun Context.themeColor(@AttrRes attrId: Int) =
    color(theme.color(attrId))

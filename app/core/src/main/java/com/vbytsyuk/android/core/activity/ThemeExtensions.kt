package com.vbytsyuk.android.core.activity

import android.content.res.Resources
import android.util.TypedValue
import androidx.annotation.AttrRes


fun Resources.Theme.color(@AttrRes colorId: Int): Int =
    TypedValue().apply { resolveAttribute(colorId, this, true) }.resourceId

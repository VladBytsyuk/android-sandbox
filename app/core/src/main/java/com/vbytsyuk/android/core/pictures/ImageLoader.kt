package com.vbytsyuk.android.core.pictures

import android.widget.ImageView
import androidx.annotation.DrawableRes


interface ImageLoader {
    fun clear(view: ImageView)
    fun load(imageUrl: String, intoView: ImageView)
    fun load(@DrawableRes drawableId: Int, intoView: ImageView)
}

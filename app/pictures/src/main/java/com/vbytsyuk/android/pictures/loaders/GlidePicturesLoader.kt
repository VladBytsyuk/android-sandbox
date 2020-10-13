package com.vbytsyuk.android.image.loaders

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.vbytsyuk.android.core.pictures.ImageLoader


class GlideImageLoader(private val context: Context) : ImageLoader {
    override fun clear(view: ImageView) {
        Glide.with(context).clear(view)
    }

    override fun load(imageUrl: String, intoView: ImageView) {
        Glide.with(context).load(imageUrl).into(intoView)
    }

    override fun load(@DrawableRes drawableId: Int, intoView: ImageView) {
        Glide.with(context).load(drawableId).into(intoView)
    }
}

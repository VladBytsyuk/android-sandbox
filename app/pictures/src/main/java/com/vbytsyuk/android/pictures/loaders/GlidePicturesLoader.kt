package com.vbytsyuk.android.pictures.loaders

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.vbytsyuk.android.core.pictures.PicturesLoader
import com.vbytsyuk.android.pictures.R


class GlidePicturesLoader(private val context: Context) : PicturesLoader {
    override fun clear(view: ImageView) {
        Glide.with(context).clear(view)
    }

    override fun load(imageUrl: String, intoView: ImageView) {
        Glide.with(context).load(imageUrl).error(R.drawable.ic_error).into(intoView)
    }

    override fun load(@DrawableRes drawableId: Int, intoView: ImageView) {
        Glide.with(context).load(drawableId).error(R.drawable.ic_error).into(intoView)
    }
}

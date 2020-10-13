package com.vbytsyuk.android.pictures.loaders

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.vbytsyuk.android.core.pictures.PicturesLoader
import com.vbytsyuk.android.pictures.R
import java.lang.Exception


class PicassoPicturesLoader : PicturesLoader {
    override fun clear(view: ImageView) {
        view.setImageResource(0)
    }

    override fun load(imageUrl: String, intoView: ImageView) {
        Picasso.get().load(imageUrl).into(intoView, callback(intoView))
    }

    /* Picasso can't work with vector drawables. */
    override fun load(@DrawableRes drawableId: Int, intoView: ImageView) {
        Picasso.get().load(drawableId).into(intoView, callback(intoView))
    }

    private fun callback(view: ImageView) = object : Callback {
        override fun onSuccess() { /* do nothing */ }
        override fun onError(e: Exception?) = view.setImageResource(R.drawable.ic_error)
    }
}

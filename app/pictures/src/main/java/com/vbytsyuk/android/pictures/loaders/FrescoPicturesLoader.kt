package com.vbytsyuk.android.pictures.loaders

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.vbytsyuk.android.core.pictures.PicturesLoader


class FrescoPicturesLoader : PicturesLoader {
    companion object {
        fun init(context: Context) = Fresco.initialize(context)
    }

    override fun clear(view: ImageView) {
        if (view is SimpleDraweeView) view.setActualImageResource(0)
    }

    override fun load(imageUrl: String, intoView: ImageView) {
        if (intoView is SimpleDraweeView) {
            intoView.setImageURI(imageUrl)
            intoView.controller =
                Fresco.newDraweeControllerBuilder().setUri(imageUrl).setAutoPlayAnimations(true).build()
        }
    }

    override fun load(@DrawableRes drawableId: Int, intoView: ImageView) {
        if (intoView is SimpleDraweeView) intoView.setActualImageResource(drawableId)
    }
}

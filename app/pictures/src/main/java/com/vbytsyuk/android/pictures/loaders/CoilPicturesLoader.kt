package com.vbytsyuk.android.pictures.loaders

import android.content.Context
import android.os.Build.VERSION.SDK_INT
import android.widget.ImageView
import androidx.annotation.DrawableRes
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load
import com.vbytsyuk.android.core.pictures.PicturesLoader
import com.vbytsyuk.android.pictures.R


class CoilPicturesLoader(context: Context) : PicturesLoader {
    private val imageLoader = ImageLoader.Builder(context)
        .componentRegistry { this.add(if (SDK_INT >= 28) ImageDecoderDecoder() else GifDecoder()) }
        .build()

    override fun clear(view: ImageView) {
        view.setImageResource(0)
    }

    override fun load(imageUrl: String, intoView: ImageView) {
        intoView.load(imageUrl, imageLoader) { error(R.drawable.ic_error) }
    }

    override fun load(@DrawableRes drawableId: Int, intoView: ImageView) {
        intoView.load(drawableId, imageLoader) { error(R.drawable.ic_error) }
    }
}

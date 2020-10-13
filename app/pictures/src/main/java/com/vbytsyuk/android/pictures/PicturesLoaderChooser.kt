package com.vbytsyuk.android.pictures

import android.content.Context
import com.vbytsyuk.android.core.pictures.PicturesLoader
import com.vbytsyuk.android.pictures.loaders.GlidePicturesLoader
import com.vbytsyuk.android.pictures.loaders.PicassoPicturesLoader


class PicturesLoaderChooser(context: Context) {
    enum class Loader { GLIDE, PICASSO }

    private val glidePicturesLoader = GlidePicturesLoader(context)
    private val picassoPicturesLoader = PicassoPicturesLoader()

    var loader: Loader = Loader.GLIDE

    val picturesLoader: PicturesLoader get() = when (loader) {
        Loader.GLIDE -> glidePicturesLoader
        Loader.PICASSO -> picassoPicturesLoader
    }
}

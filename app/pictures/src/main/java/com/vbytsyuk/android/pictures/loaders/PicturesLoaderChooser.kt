package com.vbytsyuk.android.pictures.loaders

import android.content.Context
import com.vbytsyuk.android.core.pictures.PicturesLoader
import com.vbytsyuk.android.pictures.screen.SelectedLibrary


class PicturesLoaderChooser(context: Context) {
    private val glidePicturesLoader = GlidePicturesLoader(context)
    private val picassoPicturesLoader = PicassoPicturesLoader()

    var loader: SelectedLibrary = SelectedLibrary.GLIDE

    val picturesLoader: PicturesLoader get() = when (loader) {
        SelectedLibrary.GLIDE -> glidePicturesLoader
        SelectedLibrary.PICASSO -> picassoPicturesLoader
    }
}

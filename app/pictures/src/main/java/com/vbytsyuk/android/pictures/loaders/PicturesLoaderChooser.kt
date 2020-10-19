package com.vbytsyuk.android.pictures.loaders

import com.vbytsyuk.android.core.pictures.PicturesLoader
import com.vbytsyuk.android.pictures.screen.SelectedLibrary


class PicturesLoaderChooser(
    private val glidePicturesLoader: GlidePicturesLoader,
    private val picassoPicturesLoader: PicassoPicturesLoader,
    private val frescoPicturesLoader: FrescoPicturesLoader,
    private val coilPicturesLoader: CoilPicturesLoader
) {
    var loader: SelectedLibrary = SelectedLibrary.GLIDE

    val picturesLoader: PicturesLoader get() = when (loader) {
        SelectedLibrary.GLIDE -> glidePicturesLoader
        SelectedLibrary.PICASSO -> picassoPicturesLoader
        SelectedLibrary.FRESCO -> frescoPicturesLoader
        SelectedLibrary.COIL -> coilPicturesLoader
    }
}

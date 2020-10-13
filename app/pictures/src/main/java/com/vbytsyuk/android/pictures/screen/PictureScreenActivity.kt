package com.vbytsyuk.android.pictures.screen

import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.viewModels
import com.vbytsyuk.android.core.activity.lazyFindViewById
import com.vbytsyuk.android.core.mvi.CoreMviActivity
import com.vbytsyuk.android.core.pictures.PicturesLoader
import com.vbytsyuk.android.pictures.PicturesLoaderChooser
import com.vbytsyuk.android.pictures.PicturesLoaderChooser.*
import com.vbytsyuk.android.pictures.R


class PictureScreenActivity : CoreMviActivity<PictureScreenState, PictureScreenInteractor>(
    layoutId = R.layout.activity_pictures_main,
    titleId = R.string.isa_title
) {
    override val interactor: PictureScreenInteractor by viewModels()
    private val picturesLoaderChooser = PicturesLoaderChooser(context = this)
    private val picturesLoader: PicturesLoader get() = picturesLoaderChooser.picturesLoader

    private val imageView: ImageView by lazyFindViewById(R.id.apmImageView)
    private val radioButtonGlide: RadioButton by lazyFindViewById(R.id.apmRbGlide)
    private val radioButtonPicasso: RadioButton by lazyFindViewById(R.id.apmRbPicasso)
    private val buttonClear: Button by lazyFindViewById(R.id.apmBtnClear)
    private val buttonVector: Button by lazyFindViewById(R.id.apmBtnVector)
    private val buttonRaster: Button by lazyFindViewById(R.id.apmBtnRaster)
    private val buttonRemote: Button by lazyFindViewById(R.id.apmBtnRemote)

    override fun render(state: PictureScreenState): Any? = when (state) {
        PictureScreenState.Empty ->
            picturesLoader.clear(view = imageView)

        is PictureScreenState.LocalDrawable ->
            picturesLoader.load(drawableId = state.drawableId, intoView = imageView)

        is PictureScreenState.RemotePicture ->
            picturesLoader.load(imageUrl = state.url, intoView = imageView)
    }

    override fun setClickListeners() {
        buttonClear.setOnClickListener { interactor.tapOnClear() }
        buttonVector.setOnClickListener { interactor.tapOnLoadVector() }
        buttonRaster.setOnClickListener { interactor.tapOnLoadRaster() }
        buttonRemote.setOnClickListener { interactor.tapOnLoadRemote() }
        radioButtonGlide.setOnClickListener { selectLoader(Loader.GLIDE) }
        radioButtonPicasso.setOnClickListener { selectLoader(Loader.PICASSO) }
    }

    private fun selectLoader(loader: Loader) {
        interactor.tapOnClear()
        picturesLoaderChooser.loader = loader
    }
}

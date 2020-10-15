package com.vbytsyuk.android.pictures.screen

import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.vbytsyuk.android.core.activity.lazyFindViewById
import com.vbytsyuk.android.core.mvi.CoreMviActivity
import com.vbytsyuk.android.core.pictures.PicturesLoader
import com.vbytsyuk.android.pictures.loaders.PicturesLoaderChooser
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
    private val buttonGif: Button by lazyFindViewById(R.id.apmBtnGif)


    override fun setClickListeners() {
        buttonClear.setOnClickListener { interactor.tapOnClear() }
        buttonVector.setOnClickListener { interactor.tapOnLoadVector() }
        buttonRaster.setOnClickListener { interactor.tapOnLoadRaster() }
        buttonRemote.setOnClickListener { interactor.tapOnLoadRemote() }
        buttonGif.setOnClickListener { interactor.tapOnLoadGif() }
        radioButtonGlide.setOnClickListener { interactor.tapOnGlide() }
        radioButtonPicasso.setOnClickListener { interactor.tapOnPicasso() }
    }


    override fun render(state: PictureScreenState) {
        renderLibrary(state.library)
        renderImage(state.action)
        renderSelectedButtons(state.selectedButton)
    }

    private fun renderLibrary(library: SelectedLibrary) {
        picturesLoaderChooser.loader = library
        when (library) {
            SelectedLibrary.GLIDE -> radioButtonGlide.isChecked = true
            SelectedLibrary.PICASSO -> radioButtonPicasso.isChecked = true
        }
    }

    private fun renderImage(action: PictureLoadAction) = when (action) {
        PictureLoadAction.Clear -> picturesLoader.clear(view = imageView)
        is PictureLoadAction.LocalDrawable -> picturesLoader.load(drawableId = action.drawableId, intoView = imageView)
        is PictureLoadAction.RemotePicture -> picturesLoader.load(imageUrl = action.url, intoView = imageView)
    }

    private fun renderSelectedButtons(selectedButton: SelectedButton) {
        listOf(buttonClear, buttonVector, buttonRaster, buttonRemote, buttonGif)
            .forEach { it.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200)) }
        getButtonView(selectedButton)?.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_200))
    }

    private fun getButtonView(selectedButton: SelectedButton): Button? =  when (selectedButton) {
        SelectedButton.VECTOR -> buttonVector
        SelectedButton.RASTER -> buttonRaster
        SelectedButton.REMOTE -> buttonRemote
        SelectedButton.GIF -> buttonGif
        SelectedButton.NONE -> null
    }
}

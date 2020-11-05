package com.vbytsyuk.android.pictures.screen

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import com.facebook.drawee.view.DraweeView
import com.facebook.drawee.view.SimpleDraweeView
import com.vbytsyuk.android.core.Theme
import com.vbytsyuk.android.core.appbar.AppBarConfigurator
import com.vbytsyuk.android.core.appbar.ToolBarConfigurator
import com.vbytsyuk.android.core.activity.lazyFindViewById
import com.vbytsyuk.android.core.mvi.CoreMviActivity
import com.vbytsyuk.android.core.pictures.PicturesLoader
import com.vbytsyuk.android.core.themeColor
import com.vbytsyuk.android.pictures.R
import com.vbytsyuk.android.pictures.loaders.PicturesLoaderChooser
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class PictureScreenActivity : CoreMviActivity<PictureScreenState, PictureScreenInteractor>(
    layoutId = R.layout.activity_pictures_main,
    themeLight = R.style.Theme_Sandbox_Light_NoActionBar,
    themeDark = R.style.Theme_Sandbox_Dark_NoActionBar
) {
    override val interactor: PictureScreenInteractor by viewModel()
    private val picturesLoaderChooser: PicturesLoaderChooser by inject()
    private val picturesLoader: PicturesLoader get() = picturesLoaderChooser.picturesLoader

    private val imageView: ImageView by lazyFindViewById(R.id.apmImageView)
    private val draweeView: SimpleDraweeView by lazyFindViewById(R.id.apmDraweeView)
    private val radioButtonGlide: RadioButton by lazyFindViewById(R.id.apmRbGlide)
    private val radioButtonPicasso: RadioButton by lazyFindViewById(R.id.apmRbPicasso)
    private val radioButtonFresco: RadioButton by lazyFindViewById(R.id.apmRbFresco)
    private val radioButtonCoil: RadioButton by lazyFindViewById(R.id.apmRbCoil)
    private val buttonClear: Button by lazyFindViewById(R.id.apmBtnClear)
    private val buttonVector: Button by lazyFindViewById(R.id.apmBtnVector)
    private val buttonRaster: Button by lazyFindViewById(R.id.apmBtnRaster)
    private val buttonRemote: Button by lazyFindViewById(R.id.apmBtnRemote)
    private val buttonGif: Button by lazyFindViewById(R.id.apmBtnGif)


    override val appBarConfigurator = ToolBarConfigurator(
        toolbarId = R.id.apmToolbar,
        titleId = R.string.isa_title,
        leftButton = AppBarConfigurator.LeftButton(R.drawable.ic_arrow_back) { finish() }
    )


    override fun registerViewToInteractorActions(): Map<View, () -> Unit> = mapOf(
        buttonClear to { interactor.tapOnClear() },
        buttonVector to { interactor.tapOnLoadVector() },
        buttonRaster to { interactor.tapOnLoadRaster() },
        buttonRemote to { interactor.tapOnLoadRemote() },
        buttonGif to { interactor.tapOnLoadGif() },
        radioButtonGlide to { interactor.tapOnGlide() },
        radioButtonPicasso to { interactor.tapOnPicasso() },
        radioButtonFresco to { interactor.tapOnFresco() },
        radioButtonCoil to { interactor.tapOnCoil() }
    )


    override fun render(state: PictureScreenState) {
        renderLibrary(state.library)
        renderImage(state.library, state.action)
        renderSelectedButtons(state.selectedButton)
    }

    private fun renderLibrary(library: SelectedLibrary) {
        picturesLoaderChooser.loader = library
        val radioButton = when (library) {
            SelectedLibrary.GLIDE -> radioButtonGlide
            SelectedLibrary.PICASSO -> radioButtonPicasso
            SelectedLibrary.FRESCO -> radioButtonFresco
            SelectedLibrary.COIL -> radioButtonCoil
        }
        radioButton.isChecked = true

        imageView.visibility = View.GONE
        draweeView.visibility = View.GONE
        getImageView(library).visibility = View.VISIBLE
    }

    private fun getImageView(library: SelectedLibrary) = when (library) {
        SelectedLibrary.GLIDE, SelectedLibrary.PICASSO, SelectedLibrary.COIL -> imageView
        SelectedLibrary.FRESCO -> draweeView
    }

    private fun renderImage(library: SelectedLibrary, action: PictureLoadAction) = when (action) {
        PictureLoadAction.Clear -> picturesLoader.clear(view = getImageView(library))
        is PictureLoadAction.LocalDrawable -> picturesLoader.load(drawableId = action.drawableId, intoView = getImageView(library))
        is PictureLoadAction.RemotePicture -> picturesLoader.load(imageUrl = action.url, intoView = getImageView(library))
    }

    private fun renderSelectedButtons(selectedButton: SelectedButton) {
        listOf(buttonClear, buttonVector, buttonRaster, buttonRemote, buttonGif)
            .forEach { it.setBackgroundColor(themeColor(R.attr.colorPrimary)) }
        getButtonView(selectedButton)?.setBackgroundColor(themeColor(R.attr.colorSecondary))
    }

    private fun getButtonView(selectedButton: SelectedButton): Button? = when (selectedButton) {
        SelectedButton.VECTOR -> buttonVector
        SelectedButton.RASTER -> buttonRaster
        SelectedButton.REMOTE -> buttonRemote
        SelectedButton.GIF -> buttonGif
        SelectedButton.NONE -> null
    }
}

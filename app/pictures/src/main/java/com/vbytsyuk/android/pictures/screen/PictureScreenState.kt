package com.vbytsyuk.android.pictures.screen

import androidx.annotation.DrawableRes


data class PictureScreenState(
    val library: SelectedLibrary,
    val selectedButton: SelectedButton,
    val action: PictureLoadAction
)


enum class SelectedLibrary { GLIDE, PICASSO, FRESCO, COIL }

enum class SelectedButton { VECTOR, RASTER, REMOTE, GIF, NONE }

sealed class PictureLoadAction {
    object Clear : PictureLoadAction()
    data class LocalDrawable(@DrawableRes val drawableId: Int) : PictureLoadAction()
    data class RemotePicture(val url: String) : PictureLoadAction()
}

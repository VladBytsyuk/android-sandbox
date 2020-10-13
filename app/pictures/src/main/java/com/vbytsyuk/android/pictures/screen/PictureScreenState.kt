package com.vbytsyuk.android.pictures.screen

import androidx.annotation.DrawableRes


sealed class PictureScreenState {
    object Empty : PictureScreenState()
    data class LocalDrawable(@DrawableRes val drawableId: Int) : PictureScreenState()
    data class RemotePicture(val url: String) : PictureScreenState()
}

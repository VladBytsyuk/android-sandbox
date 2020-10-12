package com.vbytsyuk.android.glide

import androidx.annotation.DrawableRes


sealed class GlideState {
    object Empty : GlideState()
    data class LocalDrawable(@DrawableRes val drawableId: Int) : GlideState()
    data class RemoteImage(val url: String) : GlideState()
}

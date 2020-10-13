package com.vbytsyuk.android.pictures.screen

import com.vbytsyuk.android.core.mvi.CoreMviInteractor
import com.vbytsyuk.android.pictures.R


class PictureScreenInteractor : CoreMviInteractor<PictureScreenState>() {
    fun tapOnClear() = stateObservable.set(PictureScreenState.Empty)
    fun tapOnLoadVector() = stateObservable.set(PictureScreenState.LocalDrawable(R.drawable.ic_android))
    fun tapOnLoadRaster() = stateObservable.set(PictureScreenState.LocalDrawable(R.drawable.ic_android_raster))
    fun tapOnLoadRemote() = stateObservable.set(PictureScreenState.RemotePicture(URL))

    companion object {
        const val URL = "https://sm.pcmag.com/pcmag_ap/news/a/a-wallpape/a-wallpaper-can-crash-some-android-10-phones_1mhp.jpg"
    }
}

package com.vbytsyuk.android.glide

import com.vbytsyuk.android.core.mvi.CoreMviInteractor


class GlideInteractor : CoreMviInteractor<GlideState>() {
    fun tapOnClear() = stateObservable.set(GlideState.Empty)
    fun tapOnLoadLocal() = stateObservable.set(GlideState.LocalDrawable(R.drawable.ic_android))
    fun tapOnLoadRemote() = stateObservable.set(GlideState.RemoteImage(URL))

    companion object {
        const val URL = "https://sm.pcmag.com/pcmag_ap/news/a/a-wallpape/a-wallpaper-can-crash-some-android-10-phones_1mhp.jpg"
    }
}

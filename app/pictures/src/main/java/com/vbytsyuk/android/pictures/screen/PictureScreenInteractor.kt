package com.vbytsyuk.android.pictures.screen

import com.vbytsyuk.android.core.mvi.CoreMviInteractor
import com.vbytsyuk.android.pictures.R
import com.vbytsyuk.android.pictures.screen.PictureLoadAction.*
import com.vbytsyuk.android.pictures.screen.SelectedButton.*
import com.vbytsyuk.android.pictures.screen.SelectedLibrary.*


class PictureScreenInteractor : CoreMviInteractor<PictureScreenState>() {
    override val initialState = PictureScreenState(library = GLIDE, selectedButton = NONE, action = Clear)


    fun tapOnGlide() = updateState {
        copy(library = GLIDE, selectedButton = NONE, action = Clear)
    }

    fun tapOnPicasso() = updateState {
        copy(library = PICASSO, selectedButton = NONE, action = Clear)
    }

    fun tapOnFresco() = updateState {
        copy(library = FRESCO, selectedButton = NONE, action = Clear)
    }

    fun tapOnCoil() = updateState {
        copy(library = COIL, selectedButton = NONE, action = Clear)
    }


    fun tapOnClear() = updateState {
        copy(selectedButton = NONE, action = Clear)
    }

    fun tapOnLoadVector() = updateState {
        copy(selectedButton = VECTOR, action = LocalDrawable(R.drawable.ic_android))
    }

    fun tapOnLoadRaster() = updateState {
        copy(selectedButton = RASTER, action = LocalDrawable(R.drawable.ic_android_raster))
    }

    fun tapOnLoadRemote() = updateState {
        copy(selectedButton = REMOTE, action = RemotePicture(REMOTE_PICTURE_URL))
    }

    fun tapOnLoadGif() = updateState {
        copy(selectedButton = GIF, action = RemotePicture(REMOTE_GIF_URL))
    }


    companion object {
        const val REMOTE_PICTURE_URL = "https://sm.pcmag.com/pcmag_ap/news/a/a-wallpape/a-wallpaper-can-crash-some-android-10-phones_1mhp.jpg"
        const val REMOTE_GIF_URL = "https://1.bp.blogspot.com/-ol1k7gQ9nYg/WwP28ewJJ3I/AAAAAAAACvg/Oo3lVZuwStU23xwlewSlQ5afbPdPWnYuwCLcBGAs/s1600/tenor.gif"
    }
}

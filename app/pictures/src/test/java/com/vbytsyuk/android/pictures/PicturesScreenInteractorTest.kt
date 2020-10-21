package com.vbytsyuk.android.pictures

import com.vbytsyuk.android.pictures.screen.*
import com.vbytsyuk.android.pictures.screen.PictureLoadAction.*
import com.vbytsyuk.android.pictures.screen.SelectedButton.*
import com.vbytsyuk.android.pictures.screen.SelectedLibrary.*
import org.junit.Test
import kotlin.test.assertEquals


class PicturesScreenInteractorTest {

    @Test
    fun `Clear Glide raster image`() = test(
        oldState = PictureScreenState(
            library = GLIDE,
            selectedButton = RASTER,
            action = LocalDrawable(RASTER_ID)
        ),
        action = { tapOnClear() },
        newState = PictureScreenState(
            library = GLIDE,
            selectedButton = NONE,
            action = Clear
        )
    )

    @Test
    fun `Clear Glide remote image`() = test(
        oldState = PictureScreenState(
            library = GLIDE,
            selectedButton = REMOTE,
            action = RemotePicture(REMOTE_URL)
        ),
        action = { tapOnClear() },
        newState = PictureScreenState(
            library = GLIDE,
            selectedButton = NONE,
            action = Clear
        )
    )

    @Test
    fun `Clear empty image`() = test(
        oldState = PictureScreenState(
            library = GLIDE,
            selectedButton = NONE,
            action = Clear
        ),
        action = { tapOnClear() },
        newState = PictureScreenState(
            library = GLIDE,
            selectedButton = NONE,
            action = Clear
        )
    )


    @Test
    fun `Switch library from Fresco to Coil`() = test(
        oldState = PictureScreenState(
            library = FRESCO,
            selectedButton = GIF,
            action = RemotePicture(GIF_URL)
        ),
        action = { tapOnCoil() },
        newState = PictureScreenState(
            library = COIL,
            selectedButton = NONE,
            action = Clear
        )
    )

    @Test
    fun `Switch library from Picasso to Picasso`() = test(
        oldState = PictureScreenState(
            library = PICASSO,
            selectedButton = GIF,
            action = RemotePicture(GIF_URL)
        ),
        action = { tapOnPicasso() },
        newState = PictureScreenState(
            library = PICASSO,
            selectedButton = NONE,
            action = Clear
        )
    )


    @Test
    fun `Select Gif after Raster on Coil`() = test(
        oldState = PictureScreenState(
            library = COIL,
            selectedButton = RASTER,
            action = LocalDrawable(RASTER_ID)
        ),
        action = { tapOnLoadGif() },
        newState = PictureScreenState(
            library = COIL,
            selectedButton = GIF,
            action = RemotePicture(GIF_URL)
        )
    )

    @Test
    fun `Select Vector after Remote on Fresco`() = test(
        oldState = PictureScreenState(
            library = FRESCO,
            selectedButton = REMOTE,
            action = RemotePicture(GIF_URL)
        ),
        action = { tapOnLoadVector() },
        newState = PictureScreenState(
            library = FRESCO,
            selectedButton = VECTOR,
            action = LocalDrawable(VECTOR_ID)
        )
    )



    private fun test(
        oldState: PictureScreenState,
        action: PictureScreenInteractor.() -> Unit,
        newState: PictureScreenState
    ) {
        val interactor = PictureScreenInteractor().apply {
            vectorDrawableId = VECTOR_ID
            rasterDrawableId = RASTER_ID
            remoteImageUrl = REMOTE_URL
            remoteGifUrl = GIF_URL
        }
        interactor.stateObservable.set(oldState)
        interactor.action()
        assertEquals(expected = newState, actual = interactor.stateObservable.get())
    }

    companion object {
        const val VECTOR_ID = 0
        const val RASTER_ID = 1
        const val REMOTE_URL = "remote"
        const val GIF_URL = "remote"
    }
}

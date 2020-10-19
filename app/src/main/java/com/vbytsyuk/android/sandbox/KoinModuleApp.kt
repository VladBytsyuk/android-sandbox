package com.vbytsyuk.android.sandbox

import com.vbytsyuk.android.core.controllers.ThemeController
import com.vbytsyuk.android.pictures.loaders.*
import com.vbytsyuk.android.pictures.screen.PictureScreenInteractor
import com.vbytsyuk.android.storage.SharedPreferenceThemeStorage
import com.vbytsyuk.android.storage.ThemeStorage
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


object KoinModulesProvider {
    val modules: List<Module>
        get() = listOf(app, pictures, core, storage)


    private val app = module {

    }

    private val pictures = module {
        viewModel { PictureScreenInteractor() }
        factory { GlidePicturesLoader(context = get()) }
        factory { PicassoPicturesLoader() }
        factory { FrescoPicturesLoader() }
        factory { CoilPicturesLoader(context = get()) }
        factory {
            PicturesLoaderChooser(
                glidePicturesLoader = get(),
                picassoPicturesLoader = get(),
                frescoPicturesLoader = get(),
                coilPicturesLoader = get()
            )
        }
    }

    private val core = module {
        factory { ThemeController(themeStorage = get()) }
    }

    private val storage = module {
        factory<ThemeStorage> { SharedPreferenceThemeStorage(context = get()) }
    }
}

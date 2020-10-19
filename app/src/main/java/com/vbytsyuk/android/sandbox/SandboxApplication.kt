package com.vbytsyuk.android.sandbox

import android.app.Application
import com.vbytsyuk.android.pictures.loaders.FrescoPicturesLoader
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class SandboxApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FrescoPicturesLoader.init(this)
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@SandboxApplication)
            modules(KoinModulesProvider.modules)
        }
    }
}

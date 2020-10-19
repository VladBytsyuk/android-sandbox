package com.vbytsyuk.android.core.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.vbytsyuk.android.core.R
import com.vbytsyuk.android.core.Theme
import com.vbytsyuk.android.core.appbar.AppBarConfigurator
import com.vbytsyuk.android.core.controllers.ThemeController
import org.koin.android.ext.android.inject


abstract class CoreActivity(
    @LayoutRes layoutId: Int
) : AppBarActivity(layoutId) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setClickListeners()
    }

    abstract fun setClickListeners()
}

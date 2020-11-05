package com.vbytsyuk.android.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.vbytsyuk.android.core.activity.CoreActivity
import com.vbytsyuk.android.core.appbar.AppBarConfigurator
import com.vbytsyuk.android.core.appbar.ToolBarConfigurator


class JetpackActivity : CoreActivity(
    layoutId = R.layout.activity,
    themeLight = R.style.Theme_Sandbox_Light_NoActionBar,
    themeDark = R.style.Theme_Sandbox_Dark_NoActionBar
), LifecycleObserver {
    override val appBarConfigurator = ToolBarConfigurator(
        toolbarId = R.id.asToolbar,
        titleId = R.string.aj_title,
        leftButton = AppBarConfigurator.LeftButton(R.drawable.ic_arrow_back) { finish() }
    )

    override fun setClickListeners() {
        /* do nothing */
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(this)
    }

    private fun logLC(methodName: String) {
        Log.i("Lifecycle:", "$methodName()")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun lcOnCreate() = logLC("lcOnCreate")


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun lcOnStart() = logLC("lcOnStart")

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun lcOnResume() = logLC("lcOnResume")


    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun lcOnPause() = logLC("lcOnPause")

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun lcOnStop() = logLC("lcOnStop")

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun lcOnDestroy() = logLC("lcOnDestroy")

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun lcOnAny() = logLC("lcOnAny")
}

package com.vbytsyuk.android.lifecycle

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.vbytsyuk.android.core.activity.CoreActivity
import com.vbytsyuk.android.core.appbar.AppBarConfigurator
import com.vbytsyuk.android.core.appbar.ToolBarConfigurator


class SimpleActivity : CoreActivity(layoutId = R.layout.activity) {
    override val appBarConfigurator = ToolBarConfigurator(
        toolbarId = R.id.asToolbar,
        titleId = R.string.as_title,
        leftButton = AppBarConfigurator.LeftButton(R.drawable.ic_arrow_back) { finish() }
    )

    override fun setClickListeners() {
        /* do nothing */
    }


    private fun logLC(methodName: String) = Log.i("Lifecycle:", "$methodName()")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logLC("onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        logLC("onRestart")
    }

    override fun onStart() {
        super.onStart()
        logLC("onStart")
    }

    override fun onResume() {
        super.onResume()
        logLC("onResume")
    }


    override fun onPause() {
        super.onPause()
        logLC("onPause")
    }

    override fun onStop() {
        super.onStop()
        logLC("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLC("onDestroy")
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        logLC("onRestoreInstanceState")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        logLC("onSaveInstanceState")
    }

}

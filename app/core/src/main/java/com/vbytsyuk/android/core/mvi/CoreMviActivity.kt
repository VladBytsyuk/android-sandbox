package com.vbytsyuk.android.core.mvi

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.vbytsyuk.android.core.activity.CoreActivity


abstract class CoreMviActivity<State, Interactor : CoreMviInteractor<State>>(
    @LayoutRes layoutId: Int
) : CoreActivity(layoutId) {
    abstract val interactor: Interactor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setClickListeners()
    }

    abstract fun setClickListeners()

    override fun onResume() {
        super.onResume()
        interactor.stateObservable.subscribe(subscriber = this) { render(it) }
    }

    override fun onPause() {
        interactor.stateObservable.unsubscribe(subscriber = this)
        super.onPause()
    }

    open fun render(state: State): Any? = Unit
}

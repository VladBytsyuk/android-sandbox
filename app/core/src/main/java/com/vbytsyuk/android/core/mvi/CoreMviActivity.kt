package com.vbytsyuk.android.core.mvi

import android.view.View
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import com.vbytsyuk.android.core.activity.CoreActivity


abstract class CoreMviActivity<State, Interactor : CoreMviInteractor<State>>(
    @LayoutRes layoutId: Int,
    @StringRes titleId: Int? = null
) : CoreActivity(layoutId, titleId) {
    abstract val interactor: Interactor

    override fun onResume() {
        super.onResume()
        interactor.stateObservable.subscribe(subscriber = this) { render(it) }
        interactor.updateState()
    }

    override fun onPause() {
        interactor.stateObservable.unsubscribe(subscriber = this)
        super.onPause()
    }

    open fun render(state: State): Any? = Unit


    abstract fun registerViewToInteractorActions(): Map<View, Interactor.() -> Unit>

    override fun setClickListeners() {
        registerViewToInteractorActions().forEach { (view, action) ->
            view.setOnClickListener { interactor.action() }
        }
    }
}

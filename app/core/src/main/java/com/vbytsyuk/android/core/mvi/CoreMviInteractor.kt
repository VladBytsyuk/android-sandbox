package com.vbytsyuk.android.core.mvi

import androidx.lifecycle.ViewModel
import com.vbytsyuk.android.core.observer.CoreObservable


abstract class CoreMviInteractor<State> : ViewModel() {
    abstract val initialState: State
    val stateObservable: CoreObservable<State>
            by lazy(mode = LazyThreadSafetyMode.NONE) { CoreObservable.create(initialState) }

    fun updateState(mapper: State.() -> State) {
        val oldState = stateObservable.get()
        val newState = oldState.mapper()
        stateObservable.set(newState)
    }
}

package com.vbytsyuk.android.core.mvi

import androidx.lifecycle.ViewModel
import com.vbytsyuk.android.core.observer.CoreObservable


open class CoreMviInteractor<State> : ViewModel() {
    val stateObservable: CoreObservable<State> = CoreObservable.create()
}

package com.vbytsyuk.android.core


fun <T> nonThreadSafeLazy(initializer: () -> T): Lazy<T> =
        lazy(LazyThreadSafetyMode.NONE, initializer)

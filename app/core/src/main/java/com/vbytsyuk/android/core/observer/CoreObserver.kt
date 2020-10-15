package com.vbytsyuk.android.core.observer


typealias Subscription<T> = (T) -> Unit

interface CoreObservable<T> {
    fun subscribe(subscriber: Any, subscription: Subscription<T>)
    fun unsubscribe(subscriber: Any)

    fun set(value: T)
    fun get(): T

    companion object {
        fun <T> create(initialValue: T): CoreObservable<T> = CoreObservableImpl(initialValue)
    }
}

private class CoreObservableImpl<T>(initialValue: T) : CoreObservable<T> {
    private val hashMap: MutableMap<Any, Subscription<T>> = hashMapOf()

    override fun subscribe(subscriber: Any, subscription: Subscription<T>) {
        hashMap[subscriber] = subscription
    }

    override fun unsubscribe(subscriber: Any) {
        hashMap.remove(subscriber)
    }


    private var lastValue: T = initialValue

    override fun set(value: T) {
        lastValue = value
        hashMap.values.forEach { subscription -> subscription(value) }
    }

    override fun get(): T = lastValue
}

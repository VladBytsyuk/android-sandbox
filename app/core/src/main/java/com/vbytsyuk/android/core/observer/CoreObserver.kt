package com.vbytsyuk.android.core.observer


typealias Subscription<T> = (T) -> Unit

interface CoreObservable<T> {
    fun subscribe(subscriber: Any, subscription: Subscription<T>)
    fun unsubscribe(subscriber: Any)

    fun set(value: T)

    companion object {
        fun <T> create(): CoreObservable<T> = CoreObservableImpl()
    }
}

private class CoreObservableImpl<T> : CoreObservable<T> {
    private val hashMap: MutableMap<Any, Subscription<T>> = hashMapOf()

    override fun subscribe(subscriber: Any, subscription: Subscription<T>) {
        hashMap[subscriber] = subscription
    }

    override fun unsubscribe(subscriber: Any) {
        hashMap.remove(subscriber)
    }


    override fun set(value: T) {
        hashMap.values.forEach { subscription -> subscription(value) }
    }
}

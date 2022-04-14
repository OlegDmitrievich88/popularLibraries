package com.example.someapp.utils

private typealias Subscriber<T> = (T?) -> Unit
class Publisher<T> {

    private var subscribers: MutableSet<Subscriber<T>>? = mutableSetOf()
    private  val value: T? = null
    private var hasFirstValue = false

    fun subscribe(subscriber: Subscriber<T>){
        subscribers?.add(subscriber)
        if(hasFirstValue){
            subscriber?.invoke(value)
        }
    }

    fun unSubscribe(subscriber: Subscriber<T>){
        subscribers?.remove(subscriber)
    }

    fun unSubscribeAll(){
        subscribers?.clear()
    }

    fun post(value: T){
        subscribers?.forEach { it.invoke(value) }
    }
}

//interface Subscriber<T> {
//    fun post(value: T)
//
//}

package com.erkuai.mydesignpatterns

class Dp13 {
    fun test() {
        val target = Adapter()
        target.request()
    }
}

/**
 * 目标接口
 */
open class Target1 {
    open fun request() {

    }
}

/**
 * 需要适配的类
 */
class Adaptee {
    fun specialRequest() {

    }
}

class Adapter : Target1() {
    private val adaptee = Adaptee() // 就是包装一个需要适配的对象
    override fun request() {
//        super.request()
        adaptee.specialRequest()
    }
}
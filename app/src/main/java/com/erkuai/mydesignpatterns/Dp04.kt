package com.erkuai.mydesignpatterns

class Dp04 {
    fun test() {
        val proxy = Proxy()
        proxy.request()
    }
}

abstract class Subject {
    abstract fun request()
}

class RealSubject : Subject() {
    override fun request() {
    }
}

class Proxy : Subject() {
    var realSubject: RealSubject? = null // 让代理持有实体，使得代理去请求的时候，实际是实体在做请求
    override fun request() {
        realSubject?.request()
    }
}
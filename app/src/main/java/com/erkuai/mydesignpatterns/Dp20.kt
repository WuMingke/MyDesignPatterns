package com.erkuai.mydesignpatterns

class Dp20 {
    fun test() {
        val h1 = ConcreteHandler1()
        val h2 = ConcreteHandler2()
        val h3 = ConcreteHandler3()
        h1.successor = h2
        h2.successor = h3

        val data = arrayListOf<Int>().apply {
            repeat(30) {
                add(it)
            }
        }
        data.forEach {
            h1.handleRequest(it)  // 不同的数据用不同的handler处理
        }
    }
}

abstract class Handler {
    var successor: Handler? = null // 设置继任者

    abstract fun handleRequest(request: Int)
}

class ConcreteHandler1 : Handler() {
    override fun handleRequest(request: Int) {
        if (request in 0..9) {
            //
        } else {
            successor?.handleRequest(request)
        }
    }

}

class ConcreteHandler2 : Handler() {
    override fun handleRequest(request: Int) {
        if (request in 10..19) {
            //
        } else {
            successor?.handleRequest(request)
        }
    }

}

class ConcreteHandler3 : Handler() {
    override fun handleRequest(request: Int) {
        if (request in 20..29) {
            //
        } else {
            successor?.handleRequest(request)
        }
    }

}
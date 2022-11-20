package com.erkuai.mydesignpatterns

class Dp06 {
    fun test() {

    }
}

abstract class Prototype {
    var id = 0

    constructor(id: Int) {
        this.id = id
    }

    abstract fun clone(): Prototype // 抽象类关键就是有这样一个clone方法
}

class ConcretePrototype1(id: Int) : Prototype(id) {
    override fun clone(): Prototype {
        // TODO: 2022/11/19 mingKE 这里有问题，并且还要区分深复制or浅复制
        return this
    }

}
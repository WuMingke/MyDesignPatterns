package com.erkuai.mydesignpatterns

import java.util.Hashtable

class Dp22 {
    fun test() {
        var extrinsicstate = 22
        val factory = FlyweightFactory()
        val flyweightA = factory.getFlyweight("A")
        flyweightA?.operation(--extrinsicstate)

        val flyweightB = factory.getFlyweight("B")
        flyweightB?.operation(--extrinsicstate)
    }
}

/**
 * 享元类的超类，
 * 通过这个接口，Flyweight可以接受并作用于外部状态
 */
abstract class Flyweight {
    abstract fun operation(extrinsicstate: Int)
}

/**
 * 继承Flyweight 并为内部状态增加存储空间
 */
class ConcreteFlyweight : Flyweight() {
    override fun operation(extrinsicstate: Int) {
    }

}

/**
 * UnSharedConcreteFlyweight 指的是那些不需要共享的 Flyweight 子类，
 */
class UnSharedConcreteFlyweight : Flyweight() {
    override fun operation(extrinsicstate: Int) {
    }

}

/**
 * 享元工厂，当用户需要 Flyweight 时，提供一个实例或者新建一个
 */
class FlyweightFactory {
    private val map = hashMapOf<String, Flyweight>()

    constructor() {
        map["A"] = ConcreteFlyweight()
        map["B"] = ConcreteFlyweight()
        map["C"] = ConcreteFlyweight()
    }

    fun getFlyweight(key: String): Flyweight? {
        return map[key]
    }
}
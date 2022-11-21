package com.erkuai.mydesignpatterns

class Dp15 {
    fun test() {
        val root = Composite("root")
        root.add(Leaf("A"))
        root.add(Leaf("B"))

        val comp = Composite("X")
        comp.add(Leaf("XA"))
        comp.add(Leaf("XB"))

        root.add(comp) // 非叶子节点的叶子
    }
}

abstract class Component1 {
    protected var name = ""

    constructor(name: String) {
        this.name = name
    }

    abstract fun add(c: Component1)
    abstract fun remove(c: Component1)
    abstract fun display(depth: Int)
}

/**
 * 叶子节点
 */
class Leaf(name: String) : Component1(name) {
    override fun add(c: Component1) {
    }

    override fun remove(c: Component1) {
    }

    override fun display(depth: Int) {
    }

}

class Composite(name: String) : Component1(name) {
    private val list = arrayListOf<Component1>() // 所有叶子结点
    override fun add(c: Component1) {
        list.add(c)
    }

    override fun remove(c: Component1) {
        list.remove(c)
    }

    override fun display(depth: Int) {
        list.forEach {
            it.display(depth + 2)
        }
    }

}
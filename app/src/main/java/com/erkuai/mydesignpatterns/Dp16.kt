package com.erkuai.mydesignpatterns

class Dp16 {
    fun test() {
        val a = ConcreteAggregate()
        a.list.add("A")
        a.list.add("B")
        a.list.add("C")

        val i = ConcreteIterator(a)
        val first = i.first()
        while (!i.isDown()) {
            i.next()
        }
    }
}

/**
 * 迭代器抽象类
 */
abstract class Iterator {
    abstract fun first(): Any
    abstract fun next(): Any
    abstract fun isDown(): Boolean
    abstract fun currentItem(): Any
}

abstract class Aggregate {
    abstract fun createIterator(): Iterator
}

class ConcreteAggregate : Aggregate() {

    val list = arrayListOf<Any>()

    override fun createIterator(): Iterator {
        return ConcreteIterator(this)
    }

    var count = list.size

    fun getItem(index: Int) = list[index]

}

class ConcreteIterator : Iterator {

    var aggregate: ConcreteAggregate? = null
    var current = 0

    constructor(aggregate: ConcreteAggregate) {
        this.aggregate = aggregate
    }

    override fun first(): Any {
        return aggregate?.getItem(0)!!
    }

    override fun next(): Any {
        var item: Any? = null
        current++
        if (current < aggregate!!.count) {
            item = aggregate!!.getItem(current)
        }
        return item!!
    }

    override fun isDown(): Boolean {
        return current >= aggregate!!.count
    }

    override fun currentItem(): Any {
        return aggregate!!.getItem(current)
    }

}
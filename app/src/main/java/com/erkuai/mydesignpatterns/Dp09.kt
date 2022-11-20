package com.erkuai.mydesignpatterns

class Dp09 {
    fun test() {
        val director = Director()
        val b1 = ConcreteBuilder1()
        val b2 = ConcreteBuilder2()

        director.build(b1)
        b1.getResult()

        director.build(b2)
        b2.getResult()
    }

    // 建造者模式是在当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时所适用的模式
}

/**
 * 产品
 */
class Product {
    private val items = arrayListOf<String>() // 产品所需要的材料
    fun add(item: String) {
        items.add(item)
    }
}

/**
 * 抽象构造者
 * 确定产品由A B组成，并声明一个得到产品的方法
 */
abstract class Builder {
    abstract fun buildPartA()
    abstract fun buildPartB()
    abstract fun getResult(): Product
}

/**
 * 具体构造者
 */
class ConcreteBuilder1 : Builder() {
    private val product = Product()
    override fun buildPartA() {
        product.add("A")
    }

    override fun buildPartB() {
        product.add("B")
    }

    override fun getResult(): Product {
        return product
    }

}

/**
 * 具体构造者
 */
class ConcreteBuilder2 : Builder() {
    private val product = Product()
    override fun buildPartA() {
        product.add("C")
    }

    override fun buildPartB() {
        product.add("D")
    }

    override fun getResult(): Product {
        return product
    }

}

/**
 * 指挥构造
 */
class Director {

    fun build(builder: Builder) {
        builder.buildPartA()
        builder.buildPartB()
    }

}




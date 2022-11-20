package com.erkuai.mydesignpatterns

class Dp07 {
    fun test() {

    }
}

abstract class AbstractClass {
    // 一些抽象行为，放到子类去实现
    abstract fun primitiveOperate1()
    abstract fun primitiveOperate2()

    // 模版方法，给出了逻辑的骨架，而逻辑的组成是一些相应的抽象操作，它们都推迟到子类实现
    fun templateMethod() {
        primitiveOperate1()
        primitiveOperate2()
    }
}

class ConcreteClassA : AbstractClass() {
    override fun primitiveOperate1() {
        // A的实现
    }

    override fun primitiveOperate2() {
        // A的实现
    }

}

class ConcreteClassB : AbstractClass() {
    override fun primitiveOperate1() {
        // B的实现
    }

    override fun primitiveOperate2() {
        // B的实现
    }

}


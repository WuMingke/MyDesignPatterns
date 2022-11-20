package com.erkuai.mydesignpatterns

import android.util.Log

class Dp03 {
    /**
     * 装饰模式是通过setComponent方法来对对象进行包装的，
     * 这样每个装饰对象的实现就和如何使用这个对象分开了
     */
    fun test() {
        val c = ConcreteComponent()
        val a = ConcreteDecoratorA()
        val b = ConcreteDecoratorB()

        a.component = c
        b.component = a
        b.operation()
    }

//    : operation: ConcreteComponent
//    : operation: Decorator
//    : operation: ConcreteDecoratorA
//    : operation: Decorator
//    : operation: ConcreteDecoratorB
}

/**
 * Component是定义一个对象接口，可以给这些对象动态地添加职责。
 * ConcreteComponent是定义一个具体的对象，也可以给这个对象添加一些职责。
 * Decorator装饰类，继承了Component，从外类来扩展Component类的功能，但对于Component来说，是无需知道Decorator存在的。
 * ConcreteDecoratorA 就是具体的装饰对象，起到给Component添加职责的功能
 */
abstract class Component {
    abstract fun operation()
}

class ConcreteComponent : Component() { // 具体对象的操作
    override fun operation() {
        Log.i("wmkwmk", "operation: ConcreteComponent")
    }

}

abstract class Decorator : Component() {
    var component: Component? = null  // 持有Component

    override fun operation() {
        component?.operation()
        Log.i("wmkwmk", "operation: Decorator")

    }
}

class ConcreteDecoratorA : Decorator() {

    private var addedSate: String = ""

    override fun operation() {
        super.operation()       // 执行原Component的operation
        addedSate = "new state" // 具体对象的operation

        Log.i("wmkwmk", "operation: ConcreteDecoratorA")

    }

}

class ConcreteDecoratorB : Decorator() {

    override fun operation() {
        super.operation()       // 执行原Component的operation
        addedBehavior()         // 具体对象的operation

        Log.i("wmkwmk", "operation: ConcreteDecoratorB")

    }

    private fun addedBehavior() {

    }
}
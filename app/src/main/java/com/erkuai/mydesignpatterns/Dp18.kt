package com.erkuai.mydesignpatterns

class Dp18 {
    fun test() {
        val ab: Abstraction = RefinedAbstraction()
        ab.implementor = ConcreteImplementorA()
        ab.operation()

        ab.implementor = ConcreteImplementorB()
        ab.operation()

    }
}

/**
 * 实现
 */
abstract class Implementor {
    abstract fun operation()
}

class ConcreteImplementorA : Implementor() {
    override fun operation() {
    }

}

class ConcreteImplementorB : Implementor() {
    override fun operation() {
    }

}

/**
 * 抽象
 */
open class Abstraction {
    var implementor: Implementor? = null

    open fun operation() {

    }
}

class RefinedAbstraction : Abstraction() {
    override fun operation() {
        super.operation()
        implementor?.operation()
    }
}
package com.erkuai.mydesignpatterns

class Dp02 {
    // 收营策略，打折什么的
    fun test() {
        val implContext = ImplContext(ConcreteStrategyA())
        implContext.useStrategy()
    }

}

/**
 * 定义所有支持的算法的公共接口
 */
abstract class Strategy {
    abstract fun algorithmInterface()
}

/**
 * 具体算法A
 */
class ConcreteStrategyA : Strategy() {
    override fun algorithmInterface() {

    }
}

/**
 * 具体算法B
 */
class ConcreteStrategyB : Strategy() {
    override fun algorithmInterface() {

    }
}

class ImplContext {
    private var strategy: Strategy? = null // 声明一个对象

    constructor(strategy: Strategy) { // 传入一个具体算法对象
        this.strategy = strategy
    }

    fun useStrategy() { // 使用算法，因为算法不同，从而结果不同
        strategy?.algorithmInterface()
    }
}






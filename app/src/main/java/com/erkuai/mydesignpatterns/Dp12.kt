package com.erkuai.mydesignpatterns

class Dp12 {
    fun test() {
        val myContext = MyContext(ConcreteStateA()) // 初始状态是A
        myContext.request() // 不断请求，同时改变状态
        myContext.request()
    }
}

class MyContext {
    var state: State

    constructor(state: State) {
        this.state = state
    }

    fun request() { // 对请求做处理，并设置下一状态
        state.handle(this)
    }
}

/**
 * 定义一个与MyContext状态相关的接口
 */
abstract class State {
    abstract fun handle(context: MyContext)
}

class ConcreteStateA : State() {
    override fun handle(context: MyContext) {
        context.state = ConcreteStateB() // 假设 A 的下一状态是 B
    }

}

class ConcreteStateB : State() {
    override fun handle(context: MyContext) {
        context.state = ConcreteStateA() // 假设 B 的下一状态是 A
    }

}

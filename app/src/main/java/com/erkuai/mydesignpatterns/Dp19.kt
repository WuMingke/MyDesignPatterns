package com.erkuai.mydesignpatterns

class Dp19 {
    fun test() {
        val r = Receiver()
        val c = ConcreteCommand(r)
        val i = Invoker()
        i.command = c
        i.execute()
    }
}

abstract class Command {
    var receiver: Receiver? = null

    constructor(receiver: Receiver) {
        this.receiver = receiver
    }

    abstract fun execute()
}

class ConcreteCommand(receiver: Receiver) : Command(receiver) {
    override fun execute() {
        receiver?.action()
    }

}

/**
 * 要求该命令执行这个请求
 */
class Invoker {
    var command: Command? = null
    fun execute() {
        command?.execute()
    }

}

/**
 * 知道如何实施执行一个与请求相关的操作，任何类都可能作为一个接收者
 */
class Receiver {
    fun action() {

    }
}
package com.erkuai.mydesignpatterns


class Dp21 {
    fun test() {
        val mediator = ConcreteMediator()
        val c1 = ConcreteColleague1(mediator) // 认识中介
        val c2 = ConcreteColleague2(mediator)

        mediator.colleague1 = c1 // 中介认识
        mediator.colleague2 = c2

        c1.send("")
        c2.send("")
    }
}

abstract class Mediator {
    abstract fun send(message: String, colleague: Colleague)
}

abstract class Colleague {
    var mediator: Mediator? = null

    constructor(mediator: Mediator) {
        this.mediator = mediator
    }
}

class ConcreteMediator : Mediator() {

    var colleague1: ConcreteColleague1? = null
    var colleague2: ConcreteColleague2? = null

    override fun send(message: String, colleague: Colleague) {
        if (colleague == colleague1) { // colleague 通过中介转发消息
            colleague2?.notify(message)
        } else {
            colleague1?.notify(message)
        }
    }

}

class ConcreteColleague1(mediator: Mediator) : Colleague(mediator) {
    fun send(message: String) {
        mediator?.send(message, this)
    }

    fun notify(message: String) {

    }
}

class ConcreteColleague2(mediator: Mediator) : Colleague(mediator) {
    fun send(message: String) {
        mediator?.send(message, this)
    }

    fun notify(message: String) {

    }
}
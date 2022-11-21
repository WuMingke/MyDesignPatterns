package com.erkuai.mydesignpatterns

class Dp14 {
    fun test() {
        val o = Originator()
        o.state = "ON"

        val c = Caretaker()
        c.memento = o.createMemento()

        o.state = "OFF" // 修改状态

        o.setMemento(c.memento!!) // 恢复
    }
}

/**
 * 发起人类
 */
class Originator {
    var state: String = ""

    fun createMemento(): Memento { // 创建备忘录，将当前需要保存的信息导入并创建一个Memento对象
        return Memento(state)
    }

    fun setMemento(memento: Memento) { // 恢复备忘录
        this.state = memento.state
    }
}

/**
 * 备忘录类
 */

class Memento {
    var state: String = ""

    constructor(state: String) {
        this.state = state
    }
}

/**
 * 管理者类
 */
class Caretaker {
    var memento: Memento? = null
}

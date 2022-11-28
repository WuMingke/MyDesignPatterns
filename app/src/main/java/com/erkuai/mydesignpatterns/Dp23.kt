package com.erkuai.mydesignpatterns

class Dp23 {
    fun test() {
        val info = Information()
        val question = arrayListOf<AbstractExpression>()
        question.add(TerminalExpression())
        question.add(TerminalExpression())
        question.add(NormalExpression())
        question.add(TerminalExpression())

        question.forEach {
            it.interpret(info)
        }
    }
}

/**
 * 声明一个抽象的解释操作，可以有很多子类，在子类中实现解释
 */
abstract class AbstractExpression {
    abstract fun interpret(info: Information)
}

class TerminalExpression : AbstractExpression() {
    override fun interpret(info: Information) {
        // 终端解释
    }

}

class NormalExpression : AbstractExpression() {
    override fun interpret(info: Information) {
        // 非终端解释
    }

}

class Information {
    var input = ""
    var output = ""
}
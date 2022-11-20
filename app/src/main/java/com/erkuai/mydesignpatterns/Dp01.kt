package com.erkuai.mydesignpatterns

class Dp01 {
    // 计算器
    fun test() {
        val operation = OperationFactory.createOperate("*") ?: return
        operation.num1 = 1
        operation.num2 = 2
        val result = operation.getResult()
    }
}

open class Operation {
    var num1 = 0
    var num2 = 0

    open fun getResult(): Int {
        return 0
    }
}

class OperationAdd : Operation() {
    override fun getResult(): Int {
        return num1 + num2
    }
}

class OperationSub : Operation() {
    override fun getResult(): Int {
        return num1 - num2
    }
}

class OperationMul : Operation() {
    override fun getResult(): Int {
        return num1 * num2
    }
}

class OperationDiv : Operation() {
    override fun getResult(): Int {
        if (num2 == 0) return 0
        return num1 / num2
    }
}

class OperationFactory {
    companion object {
        fun createOperate(operate: String): Operation? {
            return when (operate) {
                "+" -> OperationAdd()
                "-" -> OperationSub()
                "*" -> OperationMul()
                "/" -> OperationDiv()
                else -> null
            }
        }
    }
}
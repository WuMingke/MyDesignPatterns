package com.erkuai.mydesignpatterns

class Dp05 {
    // 计算器的工厂模式实现
    fun test() {
        val operateFactory: IFactory = AddFactory()
        val operate = operateFactory.createOperate()
        operate.num1 = 1
        operate.num2 = 2
        val result = operate.getResult()
    }
}

open class Operate {
    var num1 = 0
    var num2 = 0

    open fun getResult(): Int {
        return 0
    }
}

class OperateAdd : Operate() {
    override fun getResult(): Int {
        return num1 + num2
    }
}

class OperateSub : Operate() {
    override fun getResult(): Int {
        return num1 - num2
    }
}

class OperateMul : Operate() {
    override fun getResult(): Int {
        return num1 * num2
    }
}

class OperateDiv : Operate() {
    override fun getResult(): Int {
        if (num2 == 0) return 0
        return num1 / num2
    }
}

/**
 * 工厂接口
 */
interface IFactory {
    fun createOperate(): Operate
}

class AddFactory : IFactory {
    override fun createOperate(): Operate {
        return OperateAdd()
    }
}

class SubFactory : IFactory {
    override fun createOperate(): Operate {
        return OperateSub()
    }
}

class MulFactory : IFactory {
    override fun createOperate(): Operate {
        return OperateMul()
    }
}

class DivFactory : IFactory {
    override fun createOperate(): Operate {
        return OperateDiv()
    }
}





package com.erkuai.mydesignpatterns

class Dp08 {
    fun test() {
        val facade = Facade()
        facade.methodA()
        facade.methodB()
    }
}

class SubSystemOne {
    fun methodOne() {

    }
}

class SubSystemTwo {
    fun methodTwo() {

    }
}

class SubSystemThree {
    fun methodThree() {

    }
}

class Facade {
    /**
     * 外观类，需要了解所有子系统的方法或属性，进行组合，以备外界调用
     */
    private var one: SubSystemOne = SubSystemOne()
    private var two: SubSystemTwo = SubSystemTwo()
    private var three: SubSystemThree = SubSystemThree()

    fun methodA() {
        one.methodOne()
        two.methodTwo()
        three.methodThree()
    }

    fun methodB() {
        one.methodOne()
    }
}
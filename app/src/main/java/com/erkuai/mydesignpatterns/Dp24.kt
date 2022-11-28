package com.erkuai.mydesignpatterns

class Dp24 {
    fun test() {
        val o = ObjectStructure()
        o.attach(ConcreteElementA())
        o.attach(ConcreteElementB())

        val visitorA = ConcreteVisitorA()
        val visitorB = ConcreteVisitorB()

        o.accept(visitorA)
        o.accept(visitorB)
    }
}

abstract class Visitor {
    abstract fun visitA(concreteElementA: ConcreteElementA)
    abstract fun visitB(concreteElementB: ConcreteElementB)
}

class ConcreteVisitorA : Visitor() {
    override fun visitA(concreteElementA: ConcreteElementA) {
    }

    override fun visitB(concreteElementB: ConcreteElementB) {
    }


}

class ConcreteVisitorB : Visitor() {
    override fun visitA(concreteElementA: ConcreteElementA) {
    }

    override fun visitB(concreteElementB: ConcreteElementB) {
    }


}


abstract class Element {
    abstract fun accept(visitor: Visitor)
}

class ConcreteElementA : Element() {
    override fun accept(visitor: Visitor) {
        visitor.visitA(this)
    }

}

class ConcreteElementB : Element() {
    override fun accept(visitor: Visitor) {
        visitor.visitB(this)
    }

}

class ObjectStructure {
    private val elements = arrayListOf<Element>()
    fun attach(element: Element) {
        elements.add(element)
    }

    fun detach(element: Element) {
        elements.remove(element)
    }

    fun accept(visitor: Visitor) {
        elements.forEach {
            it.accept(visitor)
        }
    }
}

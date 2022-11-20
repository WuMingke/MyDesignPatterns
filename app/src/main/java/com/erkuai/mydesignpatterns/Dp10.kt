package com.erkuai.mydesignpatterns

class Dp10 {
    fun test() {
        val concreteSubject = ConcreteSubject()
        concreteSubject.attach(ConcreteObserver(concreteSubject, "1"))
        concreteSubject.attach(ConcreteObserver(concreteSubject, "2"))
        concreteSubject.subjectState = "3"
        concreteSubject.notify1()
    }
}

/**
 * 抽象观察者
 */
abstract class Observer {
    abstract fun update()
}

/**
 * 观察者集合
 */
abstract class Subject1 {
    private val listObserver = arrayListOf<Observer>()

    fun attach(observer: Observer) {
        listObserver.add(observer)
    }

    fun detach(observer: Observer) {
        listObserver.remove(observer)

    }

    fun notify1() {
        listObserver.forEach {
            it.update()
        }
    }
}

/**
 * 具体的被观察者
 */
class ConcreteSubject : Subject1() {
    var subjectState = ""
}

/**
 * 具体的观察者
 */
class ConcreteObserver : Observer {
    private var name = ""
    private var observerState = ""
    private var subject1: ConcreteSubject

    constructor(subject1: ConcreteSubject, name: String) {
        this.subject1 = subject1
        this.name = name
    }

    override fun update() {
        observerState = subject1.subjectState
    }

}

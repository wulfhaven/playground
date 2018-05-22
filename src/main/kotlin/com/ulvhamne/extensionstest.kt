package com.ulvhamne

interface TestExtensions {
    fun foo() = println("${interfaceText()} function")
    fun bar()
    fun interfaceText() = "Interface"
}

open class Concrete : TestExtensions {
    val concreteValue = "com.ulvhamne.Concrete"
    override fun bar() = println("Class function")
}

class Child : Concrete() {
    override fun interfaceText() = "com.ulvhamne.Child"
}

fun TestExtensions.baz() = println("Extended com.ulvhamne.baz ${this.interfaceText()} on object: $javaClass")
fun Concrete.bay() = println("Extended com.ulvhamne.bay concreteValue: $concreteValue on object: $javaClass")
fun Child.bax() = println("Extended com.ulvhamne.bax interfaceText():${interfaceText()} on object: $javaClass")

fun main(args: Array<String>) {
    val instance = Concrete()
    instance.foo()
    instance.bar()
    instance.baz()
    instance.bay()

    val child = Child()
    child.baz()
    child.bax()
    child.bay()
}

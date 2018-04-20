interface TestExtensions {
    fun foo() = println("${interfaceText()} function")
    fun bar()
    fun interfaceText() = "Interface"
}

open class Concrete : TestExtensions {
    val concreteValue = "Concrete"
    override fun bar() = println("Class function")
}

class Child : Concrete() {
    override fun interfaceText() = "Child"
}

fun TestExtensions.baz() = println("Extended baz ${this.interfaceText()} on object: $javaClass")
fun Concrete.bay() = println("Extended bay concreteValue: $concreteValue on object: $javaClass")
fun Child.bax() = println("Extended bax interfaceText():${interfaceText()} on object: $javaClass")

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

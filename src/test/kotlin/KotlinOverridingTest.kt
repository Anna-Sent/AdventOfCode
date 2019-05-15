package test.kotlin

open class Parent {
    open val foo = 1

    init {
        println(foo)
    }
}

class Child : Parent() {
    override val foo = 2
}

fun main() {
    Parent()
    Child()
}

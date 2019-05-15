package coursera.kotlin

class A {
    private lateinit var prop: String

    fun setUp() {
        prop = "value"
    }

    fun display() {
        println(prop)
    }
}

fun main() {
    val a = A()
    a.setUp()
    a.display()
}

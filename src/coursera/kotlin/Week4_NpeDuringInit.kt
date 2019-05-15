package coursera.kotlin

open class A(open val value: String) {
    init {
        println(value.length)
    }
}

class B(override val value: String) : A(value)

fun main() {
    B("a")
}

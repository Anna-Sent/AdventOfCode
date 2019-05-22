package coursera.kotlin_for_java_developers

internal open class A(open val value: String) {
    init {
        println(value.length)
    }
}

internal class B(override val value: String) : A(value)

fun main() {
    B("a")
}

package coursera.kotlin_for_java_developers

internal open class A(protected open val value: String) {
    init {
        println(value.length)
    }

    fun a() {}

    object Nested {
        fun a() = this
    }

    inner class B {

        fun b() {
            a()
            this@A.a()
        }

        inner class C {

            fun c() {
                a()
                this@A.a()
                b()
                this@B.b()
            }
        }
    }

    companion object {
        fun test() {}
    }
}

internal fun A.Companion.create(): A = A("")

internal class B(override val value: String) : A(value)

fun main() {
    B("a")
}

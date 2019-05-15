package coursera.kotlin

class AA {
    private lateinit var prop: String

    fun setUp() {
        prop = "value"
    }

    fun display() {
        println(prop)
    }
}

fun main() {
    val a = AA()
    a.setUp()
    a.display()
}

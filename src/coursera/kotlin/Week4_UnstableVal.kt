package coursera.kotlin

var bar: Int = 0

val foo: Int
    get() = bar++

fun main() {
    // The values should be different:
    println(foo)
    println(foo)
    println(foo)
}

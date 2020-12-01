package advent2020

fun check(expected: Int, actual: Int, fall: Boolean = true) {
    println(actual)
    if (expected != actual) {
        val msg = "expected $expected, but was: $actual"
        if (fall) {
            assert(false) { msg }
        } else {
            println(msg)
        }
    }
}

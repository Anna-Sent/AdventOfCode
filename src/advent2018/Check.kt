package advent2018

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

fun check(expected: Long, actual: Long, fall: Boolean = true) {
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

fun check(expected: String, actual: String, fall: Boolean = true) {
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

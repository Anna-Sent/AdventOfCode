package leetcode

fun String.toIntArray(): IntArray =
        removeSurrounding("[", "]")
                .replace(" ", "")
                .split(",")
                .map { it.toInt() }
                .toIntArray()

infix fun <T> T.eq(param: T) {
    println(if (this == param) "OK" else "FAILED: expected '$param', but actual '$this'")
}

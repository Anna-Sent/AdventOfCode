package leetcode

fun String.toIntArray(): IntArray =
        removeSurrounding("[", "]")
                .replace(" ", "")
                .replace("\n", "")
                .split(",")
                .mapNotNull { it.toIntOrNull() }
                .toIntArray()

infix fun <T> T.eq(param: T) {
    println(if (this == param) "OK" else "FAILED: expected '$param', but actual '$this'")
}

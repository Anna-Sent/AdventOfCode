package leetcode

fun String.toIntArray(): IntArray =
        removeSurrounding("[", "]")
                .replace(" ", "")
                .split(",")
                .map { it.toInt() }
                .toIntArray()

infix fun <T> T.eq(param: T) {
    System.out.println(if (this == param) "OK" else "FAILED: expected '$this', but actual '$param'")
}

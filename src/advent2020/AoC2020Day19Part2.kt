package advent2020

private fun test(input: String): Int {
    return input.split("\n").map { it.toInt() }.sum()
}

fun main() {
    test()
}

private var result: Int = 0

private fun test() {
    result = test("""
    """.trimIndent())
    check(0, result)

    result = test("""
    """.trimIndent())
    check(0, result)
}

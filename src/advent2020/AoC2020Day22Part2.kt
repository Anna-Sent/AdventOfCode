package advent2020

private fun test(input: String): Int {
    val numbers = input.split("\n").map { it.toInt() }
    return 0
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

    result = test("""
    """.trimIndent())
    check(0, result)
}

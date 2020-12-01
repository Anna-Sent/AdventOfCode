package advent2020

private var result: Int = 0

fun main(args: Array<String>) {
    result = test("")
    check(0, result)

    result = test("")
    check(0, result)

    result = test("")
    check(0, result)

    result = test("")
    check(0, result)

    result = test("""
    """.trimIndent())
    check(1, result)
}

private fun test(input: String): Int {
    return 0
}

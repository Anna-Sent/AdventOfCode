package advent2023

private var result = 0

fun main() {
    result = test(
        """
    """.trimIndent()
    )
    check(0, result)

    result = test(
        """
    """.trimIndent()
    )
    check(0, result)
}

private fun test(input: String): Int {
    return 0
}
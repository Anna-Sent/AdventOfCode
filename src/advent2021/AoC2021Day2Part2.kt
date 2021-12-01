package advent2021

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
    val measurements = input.split("\n")
    var count = 0
    return count
}

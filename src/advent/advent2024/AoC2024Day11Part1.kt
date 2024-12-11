package advent.advent2024

private var result = 0

fun main() {
    result = test(
        """
            125 17
    """.trimIndent(), 6
    )
    check(22, result)

    result = test(
        """
            125 17
    """.trimIndent(), 25
    )
    check(55312, result)

    result = test(
        """
            9759 0 256219 60 1175776 113 6 92833
    """.trimIndent(), 25
    )
    check(186996, result)
}

private fun test(input: String, count: Int): Int {
    var numbers = input.split(" ").map(String::toLong)
    for (i in 1..count) {
        val newNumbers = mutableListOf<Long>()
        for (number in numbers) {
            val numberStr = number.toString()
            when {
                number == 0L -> newNumbers += 1
                numberStr.length % 2 == 0 -> {
                    newNumbers += numberStr.substring(0, numberStr.length / 2).toLong()
                    newNumbers += numberStr.substring(numberStr.length / 2).toLong()
                }

                else -> newNumbers += number * 2024
            }
        }
        numbers = newNumbers
    }
    return numbers.size
}

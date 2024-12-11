package advent.advent2024

private var result = 0L

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

    result = test(
        """
            9759 0 256219 60 1175776 113 6 92833
       """.trimIndent(), 75
    )
    check(221683913164898, result)
}

private fun test(input: String, count: Int): Long {
    var numbers = input.split(" ").map(String::toLong).associateWith { 1L }
    for (i in 1..count) {
        val newNumbers = mutableMapOf<Long, Long>()
        for ((number, value) in numbers) {
            val numberStr = number.toString()
            when {
                number == 0L -> {
                    newNumbers[1] = (newNumbers[1] ?: 0) + value
                }

                numberStr.length % 2 == 0 -> {
                    val first = numberStr.substring(0, numberStr.length / 2).toLong()
                    newNumbers[first] = (newNumbers[first] ?: 0) + value
                    val second = numberStr.substring(numberStr.length / 2).toLong()
                    newNumbers[second] = (newNumbers[second] ?: 0) + value
                }

                else -> {
                    val newNumber = number * 2024
                    newNumbers[newNumber] = (newNumbers[newNumber] ?: 0) + value
                }
            }
        }
        numbers = newNumbers
    }
    return numbers.values.sum()
}

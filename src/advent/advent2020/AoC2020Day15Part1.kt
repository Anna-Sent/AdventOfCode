package advent.advent2020

private fun test(input: String): Int {
    val numbers = input.split(",").map { it.toInt() }.toMutableList()

    while (numbers.size < 2020) {
        val lastNumber = numbers.last()
        val lastNumberCount = numbers.count { it == lastNumber }
        numbers += if (lastNumberCount == 1) {
            0
        } else {
            val lastNumberIndex = numbers.lastIndex
            val prevLastNumberIndex = numbers.subList(0, lastNumberIndex).lastIndexOf(lastNumber)
            (lastNumberIndex - prevLastNumberIndex)
        }
        println(numbers.last())
    }

    return numbers.last()
}

fun main() {
    test()
}

private var result: Int = 0

private fun test() {
    result = test("0,3,6")
    check(436, result)

    result = test("1,3,2")
    check(1, result)

    result = test("2,1,3")
    check(10, result)

    result = test("1,2,3")
    check(27, result)

    result = test("2,3,1")
    check(78, result)

    result = test("3,2,1".trimIndent())
    check(438, result)

    result = test("3,1,2")
    check(1836, result)

    result = test("9,12,1,4,17,0,18")
    check(610, result)
}

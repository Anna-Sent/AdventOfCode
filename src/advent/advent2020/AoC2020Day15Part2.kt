package advent.advent2020

private fun test(input: String): Int {
    val numbers = input.split(",").map { it.toInt() }.toMutableList()

    val counts = numbers.map { it to 1 }.toMap().toMutableMap()
    val indicies = numbers.map { it to mutableListOf(numbers.indexOf(it)) }.toMap().toMutableMap()

    var size = numbers.size
    while (size < 30000000) {
        val lastNumberIndex = size - 1
        val lastNumber = numbers[lastNumberIndex]

        val lastNumberCount = counts[lastNumber]!!
        val newNumber = if (lastNumberCount == 1) {
            0
        } else {
            val inds = indicies[lastNumber]!!
            val lst = inds[inds.size - 1]
            val prv = inds[inds.size - 2]
            lst - prv
        }

        numbers += newNumber

        counts[newNumber] = (counts[newNumber] ?: 0) + 1
        val inds = indicies.getOrPut(newNumber) { mutableListOf() }
        inds += size

        size = numbers.size
    }

    return numbers.last()
}

fun main() {
    test()
}

private var result: Int = 0

private fun test() {
    result = test("0,3,6")
    check(175594, result)

    result = test("1,3,2")
    check(2578, result)

    result = test("2,1,3")
    check(3544142, result)

    result = test("1,2,3")
    check(261214, result)

    result = test("2,3,1")
    check(6895259, result)

    result = test("3,2,1".trimIndent())
    check(18, result)

    result = test("3,1,2")
    check(362, result)

    result = test("9,12,1,4,17,0,18")
    check(1407, result)
}

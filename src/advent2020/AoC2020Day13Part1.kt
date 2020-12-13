package advent2020

private fun test(start: Int, input: String): Int {
    val ids = input.split(",").mapNotNull { it.toIntOrNull() }
    var min: Int? = null
    var minId: Int? = null
    for (id in ids) {
        val minutesToNext = id - start % id
        if (min == null || min > minutesToNext) {
            min = minutesToNext
            minId = id
        }
    }
    return minId!! * min!!
}

fun main() {
    test()
}

private var result: Int = 0

private fun test() {
    result = test(
            939,
            "7,13,x,x,59,x,31,19"
    )
    check(295, result)

    result = test(
            1014511,
            "17,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,643,x,x,x,x,x,x,x,23,x,x,x,x,13,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,29,x,433,x,x,x,x,x,37,x,x,x,x,x,x,x,x,x,x,x,x,19"
    )
    check(3464, result)
}

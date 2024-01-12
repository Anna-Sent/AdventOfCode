package advent.advent2020

private fun test(input1: String, input2: String): Int {
    val cards1 = input1.split("\n").map { it.toInt() }.toMutableList()
    val cards2 = input2.split("\n").map { it.toInt() }.toMutableList()

    var i = 1
    while (cards1.isNotEmpty() && cards2.isNotEmpty()) {
        println("round $i")
        println(cards1)
        println(cards2)

        val topCard1 = cards1[0]
        val topCard2 = cards2[0]
        if (topCard1 > topCard2) {
            cards1.removeAt(0)
            cards2.removeAt(0)
            cards1 += topCard1
            cards1 += topCard2
        } else if (topCard2 > topCard1) {
            cards1.removeAt(0)
            cards2.removeAt(0)
            cards2 += topCard2
            cards2 += topCard1
        } else {
            throw IllegalStateException("Impossible")
        }

        ++i
    }

    return if (cards1.isNotEmpty()) score(cards1) else score(cards2)
}

private fun score(cards: List<Int>): Int {
    var sum = 0
    var mult = cards.size
    for (card in cards) {
        sum += card * mult
        --mult
    }
    return sum
}

fun main() {
    test()
}

private var result: Int = 0

private fun test() {
    result = test(
            """
        9
        2
        6
        3
        1
    """.trimIndent(),
            """
        5
        8
        4
        7
        10
    """.trimIndent())
    check(306, result)

    result = test(
            """
        30
        42
        25
        7
        29
        1
        16
        50
        11
        40
        4
        41
        3
        12
        8
        20
        32
        38
        31
        2
        44
        28
        33
        18
        10
    """.trimIndent(),
            """
        36
        13
        46
        15
        27
        45
        5
        19
        39
        24
        14
        9
        17
        22
        37
        47
        43
        21
        6
        35
        23
        48
        34
        26
        49
    """.trimIndent())
    check(35818, result)
}

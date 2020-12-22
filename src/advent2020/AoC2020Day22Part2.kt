package advent2020

private fun test(input1: String, input2: String): Int {
    val cards1 = input1.split("\n").map { it.toInt() }.toMutableList()
    val cards2 = input2.split("\n").map { it.toInt() }.toMutableList()

    return play(cards1, cards2).second
}

private fun play(cards1: MutableList<Int>, cards2: MutableList<Int>): Pair<Int, Int> {
    var i = 1

    val set1 = mutableSetOf<List<Int>>()
    val set2 = mutableSetOf<List<Int>>()

    while (cards1.isNotEmpty() && cards2.isNotEmpty()) {
        println("round $i")
        println(cards1)
        println(cards2)

        if (set1.contains(cards1) || set2.contains(cards2)) {
            return 1 to score(cards1)
        } else {
            set1 += cards1.toList()
            set2 += cards2.toList()
        }

        val topCard1 = cards1[0]
        val topCard2 = cards2[0]

        if (cards1.size > topCard1 && cards2.size > topCard2) {
            cards1.removeAt(0)
            cards2.removeAt(0)
            val result = play(cards1.take(topCard1).toMutableList(), cards2.take(topCard2).toMutableList())
            if (result.first == 1) {
                cards1 += topCard1
                cards1 += topCard2
            } else {
                cards2 += topCard2
                cards2 += topCard1
            }
        } else {

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

        }

        ++i
    }

    return if (cards1.isNotEmpty()) 1 to score(cards1) else 2 to score(cards2)
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
    check(291, result)

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
    check(34771, result)
}

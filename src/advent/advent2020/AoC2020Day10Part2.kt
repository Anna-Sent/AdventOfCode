package advent.advent2020

private fun test(input: String): Long {
    val voltages = input.split("\n").map { it.toInt() }.toSortedSet()
    val max = voltages.max()!!.plus(3)
    voltages.add(max)
    val ways = LongArray(max + 1)
    ways[0] = 1
    for (voltage in voltages) {
        ways[voltage] = ways.getOrElse(voltage - 1) { 0 } +
                ways.getOrElse(voltage - 2) { 0 } +
                ways.getOrElse(voltage - 3) { 0 }
        println("$voltage ${ways[voltage]}")
    }
    return ways[max]
}

fun main() {
    test()
}

private var result: Long = 0

private fun test() {
    result = test("""
        16
        10
        15
        5
        1
        11
        7
        19
        6
        12
        4
    """.trimIndent())
    check(8, result)

    result = test("""
        28
        33
        18
        42
        31
        14
        46
        20
        48
        47
        24
        23
        49
        45
        19
        38
        39
        11
        1
        32
        25
        35
        8
        17
        7
        9
        4
        2
        34
        10
        3
    """.trimIndent())
    check(19208, result)

    result = test("""
        138
        3
        108
        64
        92
        112
        44
        53
        27
        20
        23
        77
        119
        62
        121
        11
        2
        37
        148
        34
        83
        24
        10
        79
        96
        98
        127
        7
        115
        19
        16
        78
        133
        61
        82
        91
        145
        39
        33
        13
        97
        55
        141
        1
        134
        40
        71
        54
        103
        101
        26
        47
        90
        72
        126
        124
        110
        131
        58
        12
        142
        105
        63
        75
        50
        95
        69
        25
        68
        144
        86
        132
        89
        128
        135
        65
        125
        76
        116
        32
        18
        6
        38
        109
        111
        30
        70
        143
        104
        102
        120
        31
        41
        17
    """.trimIndent())
    check(14173478093824, result)
}

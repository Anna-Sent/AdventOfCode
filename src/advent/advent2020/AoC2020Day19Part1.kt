package advent.advent2020

import java.util.regex.Pattern

private fun test(input: String): Int {
    var tokens = input.split("\n\n")
    val (rulesInput, stringsInput) = tokens

    val rules = mutableMapOf<Int, Rule1>()
    for (ruleInput in rulesInput.split("\n")) {
        tokens = ruleInput.split(": ")
        val index = tokens[0].toInt()
        val ruleDescription = tokens[1]
        val rule = if (ruleDescription == "\"a\"") {
            Rule1.SymbolRule1("a")
        } else if (ruleDescription == "\"b\"") {
            Rule1.SymbolRule1("b")
        } else {
            tokens = ruleDescription.split(" | ")
            if (tokens.size == 2) {
                val subRules1 = tokens[0].split(" ").map { it.toInt() }.toList()
                val subRules2 = tokens[1].split(" ").map { it.toInt() }.toList()
                Rule1.ComplexRule1(subRules1, subRules2)
            } else {
                val subRules = tokens[0].split(" ").map { it.toInt() }.toList()
                Rule1.SimpleRule1(subRules)
            }
        }
        rules[index] = rule
    }

    val pattern = Pattern.compile(rules[0]!!.toRegExp(rules))
    println(pattern)
    return stringsInput.split("\n").count { pattern.matcher(it).matches() }
}

fun main() {
    test()
}

private sealed class Rule1 {

    protected fun List<Int>.toRegExp(rules: Map<Int, Rule1>) =
            map { rules[it]!!.toRegExp(rules) }.reduce { acc, s -> acc + s }

    abstract fun toRegExp(rules: Map<Int, Rule1>): String

    data class SymbolRule1(val symbol: String) : Rule1() {
        override fun toRegExp(rules: Map<Int, Rule1>) = symbol
    }

    data class SimpleRule1(val subRules: List<Int>) : Rule1() {
        override fun toRegExp(rules: Map<Int, Rule1>) = subRules.toRegExp(rules)
    }

    data class ComplexRule1(val subRules1: List<Int>, val subRules2: List<Int>) : Rule1() {
        override fun toRegExp(rules: Map<Int, Rule1>) =
                "(${subRules1.toRegExp(rules)}|${subRules2.toRegExp(rules)})"
    }
}

private var result: Int = 0

private fun test() {
    result = test("""
        0: 4 1 5
        1: 2 3 | 3 2
        2: 4 4 | 5 5
        3: 4 5 | 5 4
        4: "a"
        5: "b"

        ababbb
        bababa
        abbbab
        aaabbb
        aaaabbb
    """.trimIndent())
    check(2, result)

    result = test("""
        1: 65 3 | 106 55
        21: 106 67 | 65 98
        128: 65 94 | 106 17
        104: 13 106 | 79 65
        32: 106 21 | 65 9
        78: 127 106 | 88 65
        55: 106 126 | 65 59
        114: 122 65 | 45 106
        108: 65 49 | 106 12
        31: 106 71 | 65 100
        76: 65 65 | 106 65
        15: 12 106 | 46 65
        24: 65 94 | 106 91
        38: 106 51 | 65 91
        25: 22 76
        87: 97 65 | 48 106
        113: 106 12 | 65 76
        8: 42
        9: 106 117 | 65 86
        88: 62 65 | 75 106
        94: 65 65
        122: 106 12 | 65 56
        48: 49 106 | 91 65
        33: 76 106 | 12 65
        28: 81 65 | 83 106
        35: 106 106 | 22 65
        50: 106 35 | 65 51
        58: 106 106
        0: 8 11
        64: 106 76 | 65 58
        71: 90 106 | 43 65
        12: 106 65 | 106 106
        7: 81 65 | 30 106
        60: 22 106 | 106 65
        17: 106 106 | 65 65
        105: 120 65 | 52 106
        96: 106 102 | 65 29
        57: 94 106 | 58 65
        115: 106 24 | 65 45
        127: 65 52 | 106 38
        14: 54 65 | 36 106
        45: 94 106 | 12 65
        70: 63 106 | 19 65
        44: 17 106 | 12 65
        99: 51 65 | 35 106
        36: 119 106 | 109 65
        51: 106 65
        37: 125 106 | 5 65
        86: 118 65 | 114 106
        106: "a"
        126: 94 106
        79: 34 65 | 44 106
        61: 65 68 | 106 87
        119: 34 106 | 89 65
        29: 65 81 | 106 82
        120: 49 65 | 58 106
        53: 56 106 | 49 65
        5: 35 65 | 12 106
        73: 65 94 | 106 76
        10: 65 56 | 106 58
        83: 49 106 | 17 65
        89: 49 106 | 56 65
        43: 61 65 | 96 106
        68: 65 73 | 106 6
        82: 65 56 | 106 91
        4: 65 6 | 106 38
        2: 56 106 | 46 65
        30: 46 65 | 94 106
        3: 65 97 | 106 122
        56: 106 65 | 65 106
        74: 26 106 | 10 65
        107: 105 65 | 47 106
        47: 95 106 | 116 65
        77: 33 65 | 121 106
        80: 106 78 | 65 41
        66: 65 15 | 106 93
        118: 65 50 | 106 124
        112: 4 65 | 77 106
        69: 106 37 | 65 28
        92: 65 57 | 106 64
        101: 65 60 | 106 94
        91: 106 106 | 65 106
        90: 65 107 | 106 112
        109: 57 65 | 85 106
        39: 106 122 | 65 53
        40: 12 106
        84: 106 2 | 65 128
        103: 106 123 | 65 80
        52: 60 65 | 17 106
        95: 65 60 | 106 49
        46: 22 106 | 65 65
        111: 39 106 | 70 65
        117: 115 106 | 16 65
        13: 65 25 | 106 99
        124: 91 22
        62: 65 49 | 106 91
        98: 7 65 | 16 106
        59: 106 35 | 65 60
        125: 91 65 | 12 106
        81: 106 76 | 65 49
        49: 65 22 | 106 65
        34: 106 49 | 65 17
        85: 17 22
        27: 65 65 | 65 106
        100: 20 106 | 14 65
        23: 76 106 | 49 65
        16: 106 23 | 65 108
        97: 106 56
        11: 42 31
        93: 76 65 | 94 106
        67: 110 65 | 84 106
        19: 22 35
        26: 27 65 | 56 106
        22: 106 | 65
        18: 65 12 | 106 91
        65: "b"
        72: 40 106 | 113 65
        6: 65 51 | 106 58
        116: 76 106 | 17 65
        75: 106 76 | 65 35
        41: 65 66 | 106 72
        123: 104 65 | 1 106
        63: 106 51 | 65 60
        20: 106 69 | 65 111
        42: 65 103 | 106 32
        121: 106 17 | 65 35
        110: 85 65 | 18 106
        102: 101 106 | 50 65
        54: 106 74 | 65 92

        aaaaaabababbbbabaaababbb
        abbaabbabbbbbabaaabbbbab
        abbbabbabbbababbaaaabbabaaabaaba
        bbbbbaabaaaaabbbaaabbbbbabbbaabaabaaaabb
        babbbbbbbbabbbababbababbababbbab
        bbbbabbbabaaabaaabbbbabbbbabbbabaabaaabb
        babbbababbbabaaabaaaaaaaababbabbabbbbbaaaaabababbbaaabbabbbabbab
        baaabbaaaaabbbbbabbbabab
        aabaabbaabbababbaaaaaabbbabbaabaaaaabbbaabaabbaabaaaabbaaaababaa
        aaaababaaaaabbabbbbbaaaa
        abbaaabaaabbaabaababbbab
        bbbaaaabbbabaaabbbbabaab
        aabbbababbabaaaaabaabaaa
        abaaabbbabbbabbbabababbb
        bbbaabaaaabaabaaaababbbbbbbaabba
        baababbbbbbbbabaaabaabbabaaaabba
        abbaaaabaabbababababaabaabbbabaa
        baabaaaabbbbbaaababbbbaa
        abbbabbbaabbbbbbaabbaaaa
        baaabbbbbbbbbbabababbabbabbbabbaaaababbbbbaaaaaaabbbbbaababaaaab
        baaababbbabbaabbaaabbaaa
        aabbaabaaabbbbabbbabaabb
        bbbabaaabbbbaaabaaaabaaabbabbabaaabaaaabbaabbaabaaabbabaabababbbaaabbbbbbbaabbabbbabbbba
        aabbbbbbbaabbbbbaaaabaabbbbaababaaaaabbbbbabbbbb
        bbaabaabaabaabbaabababbabaababbaaaabaabbaabbaaabaababbbb
        aabababaababbbababbbbbba
        abbbaabbaabbbbabaabaaaba
        abbbbaaabaabbbbbabbbbaaaaababababbbabbababaaaaab
        babaababbbbbbabbaabbabbbaaaabbabaabbbbaabaaabaababaabbbbaabbbaaaaaaaaaba
        ababaaabbababbabbaaabbaaabbabbab
        baabbbbbbabaabbbaabbbbbbbabbaabaaabbbabbabbbaabbaaabbbabaaaababbaabbaabb
        aabbabbbbbbabababaaaabab
        babaabbbaaabbabbaabababb
        babaaababaababbaaaaabbab
        abaabbbbababaabbbaaaaaaaabbbbaab
        bbbbbabaaabababbabbabbaababbabbaabaabaabbaaaaabbaabbbaaa
        baabbabaaaaaababbaaabbba
        bbbaaaabbbbaaaaababbabbb
        bbbbbbabababaabbbbabbbbbabbbbaaabbabaaabaabaabbbaaabbaaabaaabbbabbbaabbbbababbbbbabbbabb
        aaaaaabbbbabbababbaaababaababbab
        aaaabaaabbbaaaababbbabab
        aaaabaaabaababbabbaaaabbabbbababbabbaaab
        abbabbbbbababbabaabbaabaaabbbbabababbaababaabbaaabaaaaaabbbabaabbabbbbaaabaabbabaabbabaa
        aababbbbbaabbababaababbabaaababbaaabaaaaabababaabbabbbbabbaaaaaa
        bbabbbbaaaaabaaababaabbbaababaabbbbbbaababbbbbbabbbbbaba
        aaabbbbbabababbababbabba
        aabbaaaabaabbabaabbbaaaa
        bbbbabbbbaaaaaabaaabbbab
        aaabaaaabaabbaaaaabaaaaa
        baabbabaabbaaaabbaaaaaba
        aabbbbabbbaaaabbababaabaabbbabab
        babbbbbbaabaabbbabaaaaba
        aaaaaabbaabababaabbababa
        abaabbbbbaabbbbbaabaabbbabbabaabbaaabaababbbbbba
        ababaabbbbabaaabaaabbaab
        bbababbaabbbabbaabbbaaba
        aabaabaabaabbbbbbbaababa
        aaaaaabaabaababbbababbabaaaaabaabaaaabbbbbbbaaaabbabbbba
        abbaabaabbbbabbbbabbaaab
        baaabbaabbaababbaaaabbaa
        bbbbabbbbbaaaabaabababab
        ababbbaaaaabbbbabbbbabbbbaabbbab
        aabaabaabbababbbbbbaabaaaaaababaaaaaaabb
        bababaaaaaaabbbbabaabbaa
        abaabbbabbabaabaabbbaaba
        bbbbbbaaabbabababaababaabaaaaaababbabbaa
        ababbbbbababbabbaaaabaabbaababaa
        abbbbababbbbabbababbaaab
        bbabbaaaabbbbbbbbbabaabaabaaaaabbbaaaabaaabababbababaabbbbaaabbb
        ababbbaabaaabbabbababbbb
        bbabaaabababaaabbaabaaab
        abaaabaabababbaaabaaaaab
        babbbbbbbabbbaaabbbabbbaabbbbbbabbbaabbbbababbbb
        aaaaabaabbabbbabbbbaaaabaababbbababbaaaababaaabbaaaaaaaaababaaab
        aaaaaabbaabbaabaaaabbbaaabaaabababbabbababbaaaaa
        aabbbabaababbbaabbbbbababbaaaaab
        bbabaaabaabbbbabaababaab
        bbabababaaaabbbababaabbbababbabbabbabbba
        bbbbbabaabbabaabbaaaabba
        babaaaaaaaaabaabbbbbbbaa
        abbaabaababaabbbabbaabab
        abbbbaaabbaaaaaaabaaabaabbaaabbbaabababbbbbabbaabbabaababaaaabaababbbabbaaabbabb
        aababbaaabbbbabbbbaaabba
        baaabbabbaabbabbaaaabbbb
        aaabaaabaaaabaabbababbba
        abbbbababaaabbabaabbaaab
        bababbaaaabaabababbbabab
        ababaababbabbaaaabbbbbbabbbbbabaaabbabbbbaabaabababbaabbbabbbabb
        abbabaabbbababbaabaaaabb
        bbbaaaaabaabbaababbabbaaababbbbbaabbbaaa
        aaabbaababbbaababbbbaaabbaabaaaaabbbbabbbbbbbbbbbabbbbabaababaabbaaabaababaaaaab
        aabbaababaaaaabbbbabbbba
        baababaaabbbaaaabaaaaaaa
        abbbabbabbbaabaaaaabbbaa
        bbbaabaabbbbbbbbbbaabbbb
        aabbaabaaaaaaaabbabaaabb
        aaaabaababbbaaababaababbabbaaabaaabbaaababaabaab
        aabbaaaaabaabbabbbaabbaababbabababbbaabbbbbabbaa
        abaaaaaabbbababbabbaaabb
        aabbaababbaaaabbaabbbababbaabbbb
        abababbaabaabbbbbabaaaab
        bbaabaaaaabaabaaabbbaabbaaaaabaabbaaabbabbaaaababaabbbabaabaabbb
        abaabbbbabbbaabbabaaaaaabaaabbbbbabbabbaaaaabbab
        abaaabbbbaabaabaaabbabaa
        bbaabaaabbbbbbabbbbbbbba
        bbbaaabbbabbaabbaaabaaabbabbaabbbaabaaab
        baababbaababaabbbababbbbabaabaaaaabbabaa
        abbbabbbaababbbaaabbabba
        baaabaabaababbbbabbbbabbaaaaabababbaabbabbaaaaababaababb
        aaaabaaaaaaabababbbabaab
        bbaaabbaaabbbaaabbbaabbbabbbbbbbbabbbaaabbabbaab
        aabaabaabbaabaaabbabbabbabbaabbababaababbababbbababbabbbbbaaaaaa
        bbbababbbbabaaabbbababaa
        aaaaaaababbbaabbbabbaabbbabbbbaa
        bbbaabaabbabbbbaabbababbaaabaaaaaaabaabaaaaababbaabaaaaababaaabbaaabaabaabbaaaaa
        babaaaaabbaaaababaabbbba
        aabbababbbbababbabbababbbbbabaab
        ababaaabbbbaaaaabbaabbbb
        bbaaaabaaabaabbabbbbbbbb
        baababbbbbaabbaabbaabbba
        ababaabbaaababbabbabaaaabbaabbbbbabaabaa
        aabbbbbbbbbbbbabbaabaaab
        bbbaaaababaabbababbaaaaa
        abbbbbbaababaaaabaaabbba
        aaaababaababaaabbbbabaaa
        aaabababababaabbabbaabbb
        abbbabbaaabbaaaabbbababa
        baabbbbbbaababbaabaaaaba
        ababaabbbbaaaabbaaabaaabbbbbabaa
        baabbbababaabaabaabaaaabbbbaaabaabbabbaaabbababb
        babbbaaaabaabaabbabbaaab
        bbaabbbabaabaaabaababbabbaaaabbbbbaabbbb
        abbbbabaaabbbbbababbabbb
        aababbaaaabababbbbababaabbabbaaabaaabaabababbaaaabbbbbaabaabaabb
        aaaabaaaaabbbbabbababbab
        aaaaabbbaaaaaaabbaaabbba
        bbaababbbaaaaaabaababaaa
        aaabaaaaaaababababaaabaaabaabbaa
        abbbaabbbbbaaabbababaaabbabbbababababbbb
        aabbbbabbababbabbbbaaaba
        baababbbababbbbbbabbbbba
        abababbaaaabbabbaababbbabbbaabaabbaaaaaabbabbbba
        aabaabbbbbbbbababbbabbbbababbbaabbaaaaaaaaabaababbaabaab
        babaaaababbbababbbaabbba
        aabbbbaabaabbbbbbababaaa
        bbabbbababbaaaabbbaababbbababababbaaabaa
        ababbbbbbbaabaaaabababbb
        bbbbbabaababaababaaabbaabaaabbaababbabbb
        babaababbabababaaaaabbab
        abbaabbaaaaaabbbbbbababa
        bbababbaaabbaababaaabaaa
        abaabbbaababaaabbbaaaababbaaaabaaaabaabbbbababaa
        abaaababbaabbaabaaaaabba
        abaababaabbabbbbabaaaabb
        aaaabaabaaaaabbababababbabaaaabbbbbabbaaaababaabaaaaaaab
        aaabaaaaaabbabbbbaaaabab
        aabaababbabbbbbbaaaaaaababbaabaabbbbbabaababbaabbbaaaaabbaaababa
        aabbbabaaabbababbaabaabb
        aababbbbbabbbbabaababaab
        babbabaabaaababbaababbaaabbababbbbbaabaabbabbaab
        aaaaaabaabababaabaaabaababbaaaaabbbabababbbabaaabbbbabbabbaaaaba
        aabbbbabbbbbbaabbbbabaab
        aaaaabbbbaabbaaabaabaababaaabaab
        aabbbbbbaababbbbaaaaabbaaabbbababbbbababbaaabbbbbaaabaabaabaabaa
        babbababbabaabbbbbbbabaa
        babbababbbabaabaaaabaaaababbbbabaaabaabb
        aaaaaabbbaabbabaabbabbab
        babaababaabaabbbbaaaabba
        baaabbbbababaaabaabaaaabababbababbaabbabbbbaaaabaaabbabababbaaaa
        babbabaabaababbbbbbbbaba
        babaaaaabababbaaaaababba
        bbbbbababaabbaabbaaaabbbabbabbabbaaaabaaababbbbbaababaaabbaaaaabbaaaabbb
        bbbaababaaaaaaabaaabaaaababbbbabbabbbaaa
        abaaabaabbbbabbbbbbababa
        abaabbbbabbabbaababbbaba
        ababbaaaaaaaabbabbaaaaaa
        baaabbabbbabbababaabaabababbaabaaabbbaabaaaaabaababbabbabbbbaaaaaabaaabbabaaabbabbbaabab
        bbaaaababaabbaaabbbbbbba
        ababaabaaaababbaaaababbb
        abaaababbaaabaababbababbbaabbaaabbbababa
        abaaabaaabbaaabbbbabababbabbaabbaaaabaaa
        ababaababbababbbababbbba
        bbabaaabbbaaababaaaababaabaababa
        aabbaababbabaaaabaaababbbbabbbababbbbabbbababbbaaababaaaabaaaabb
        babbaabbbbabbabaabbbbaabbaaabaaabbaabbaa
        baaaaabbaaabbbbbabbabbaaabbbbbabaababbab
        ababbbbbbbbbbabaaabaaabb
        aababbbaaaaaababbabbbbbaabbabbba
        aabaabaabbaaaabbbaabbaaabbabbbabbbbabaaa
        babbaabaaaabbbbbaaaabbbaabaabaaaabaababa
        baabbaaaabbaaabbaaaaaaababbbbbbb
        bbabbbaaababbabbabbbbabababbaaaa
        aabaababbabbabaabbaaaababaabbbba
        aaabbbbabbbbbbbbbabababb
        baaaaababaababbbabaaaaabaaabaaaababaabbbaaabaabbabbabaabababbabaaabbbbaa
        bbaaababbbaaababbbabbbaaabbaabbaabbaaabbaaaaaaaa
        baabbaaabbbaaaabbbbababbbaaababa
        babaabbbabbababbbababaab
        bbabaaababbabaaaaaabbbaaaaababbabaabaaaabaaaaaaa
        abbaaabbbabbabaababbbaaa
        abaabbbbabaababbbababaab
        baaabbabbababbaaaaabbaab
        bbbababbabbaabbabbbbbbabbabaaabbaaabbabababbabaaaabbbaaaaaaaaaaa
        bbababaaaabbbabaabbbbaabbababbaababbabbabbbbaaaabbbbbbabbbbbabbabbbbbbaaabaaabba
        abbaaabbbbbbbbabaaabaabb
        bbbbbbbbaabbbaabbbbabbba
        aababbaaaaabaaabbabaaaab
        baabbaabbaabbabbabbbaaba
        abbababbbbaababbabaaabbbaaaaabbbabbababa
        aabaabbabbaababbbbbbaabbaaabbaaa
        bbaaababbaabbbbbaaaabaaaababaabbbabbbababbbabaab
        bbbaaabbaaabaaaababbbbabbbbaaababababaab
        bbaababbaabaaaaababaababaabbaaaabaaabbaaaabbabbabbaabbaa
        aabbbabbaaaabbbaabbbaaaa
        baabbababbababababbbbbba
        bbabbbbbabbaabaabaaaabbaaaabbaba
        babaaaaaaaabaaaaabbaabab
        bbbbbaaabaaabaaabbbabbbaaabbaaabbababbab
        baaababbaabbabbbbabbbaaa
        ababbabbabbbaabbaabbbbabbbbbaaab
        aabbbbbabaaabbbbaabaaaab
        aaabaaaaaabbabbbaaabbbbaabaaaabbaabbaabb
        bbbaabaaabaaabababaabaaa
        baabbaaaabaaabaabbaaaabababaabbabbaaabaa
        baabbababbbaaabbaaaaaaaa
        aabbaababbbbbaababbabbba
        bbabbbaaaabbbabaabbbabbabbaababbbbabbbaaababbaaaaaaaaaaaaaaaabab
        abaabbabababbbabbaababbaaaaabaabaaaabaaaabaaabbababbbaba
        ababbbaaaabbbabaabbabaaa
        baaabaabbaababbaaaaabbab
        baaabaabbabababaaabaabbbbabaabaa
        aaaabababbbabbbbababbbba
        aabbbbababbbaabbbabbbbabbbbaaaabbbabbabbaabababb
        babaabaabbbbbaabaaaaabbbabababbaaaaabababaabbaaababbabba
        bbabbabaabaababbbbbabbba
        abbababbabbabbaabbaaaaaa
        babbbbbbabbabaababbbabbaaababbabbbbababa
        aabbaabaaaaaaababaaabaabbaabbabaababbabaabababaabaaababa
        baabaaaaaababbbaabbbabaa
        abaaabaabbaaababbbaabbbb
        aabbbbababaaabaaababaaabbabbbbababbabababbaabbbaaaaaabba
        aabbbaababaaabbbbabbaaab
        abbabbbbbaaaaabababaabababbabbbaaaabbbabbaabababababbbbbaabaababaabbabbbabbbababaaabbbab
        bbabbabbbababbaaaabbabaa
        abaaaaabaabababbbbbbaaaabaabbaaababababb
        baaaaaaaaaabbabbaaabbbbbabaabaababbbaababbbbbbabababbbbbaabbabbb
        bbbbbbbbbaabbabbbbabbababbaababababaabba
        baabbabbbbbbaabbbaabbabbbbbbbabbabbabbbb
        abbbbababbbbbabaabababab
        abababbabbaaaabbbbaababbaabbbbaaaabaaaaa
        baababbbaaaabbbaaabaabbabbabbbbbabaaababbbaabbba
        bbababbbabaabbbbababbababaaaaabaaabaabbaaababbbbbabaabbbaaaabbaabbbaabbaaaabbbbb
        aaaabaabaabbbbababbababa
        aabbbbbaababaabbabbbbabbbaabbababbaaaabbbababbba
        baaabbbbbbbaabaaaaaaabbbbaabbabbaabbbaaabbaababa
        aaababbaabbaabbaaaabbbaa
        bbbbbaabababbabbabbbbbab
        baabbbbbbbaababbaabbabaa
        aabaabbaaabbbabbababaaaa
        bbbabbbbaaaabaaaababbbaabaaaaaaa
        bbabbbbbbbababbabbaaaabbabbbbbaa
        baaaaabbbaabbbbbaababbab
        bbbaaaaababbabaabbabaabb
        abbbaaabbaabbaaababaaaab
        aabbababaabababaabbabbaaaaaaaaaaababaaaa
        aaaabbbaaaaaaaabbbbaabaaababbabbbbaaabaaababbabaaaababaa
        bbbabbbabbabaabaaabbbaaaabbaabaa
        abbbbaaaabaaaaaaaaabbabbbbabbbabbababaaa
        aabbaababbbbbbbbaaabbbab
        babaabbbaabbbbbbaabbaabb
        aababbbaaaabaaabaaaabbab
        aaaababaabaabbabaaaaabaabbabbbbbababbaaa
        bbabbbaababbbbabaabaaabb
        ababaabbbbbbbbbbbaaaabbb
        baabbaaabaaababbbabbbabb
        baabbbbbababaaabaabbbbabbbabbabb
        aabbaabaababaabbabbababa
        abbbabbabaabbaabbbabaabb
        ababbabbbbabbbaabaaaabba
        bbbbbbaaabbbbbababaababaaabbbbbbbbabbaaa
        bbbbbaababaababbaaaaabaababababbbbbabbba
        abbaaabbbaaabaabbaaaabba
        baaabbabbababbabaaabbaaa
        abaabbbabbabbabaabbbbaab
        bbbaaaaabbbababbaabaaabb
        bbabaaabbbbbbabababbabbb
        aaababbabbbbbabaaabbbaaa
        abbbaabbbaaabaababbabbab
        baaabbbbaabbbababbabbababbaaabaa
        abbabbaaaabaababbbbabbabaaabbbaa
        abbababbbabaabbbaaabbbbbaababbaababbabbbbabaabbaaaabaaba
        baaabaabbbbbbbbbabbbaaba
        ababaaabbaabbabbbaaaabaaabbaabbbaababaab
        abbbabbaabbabaabbabaabbbbbababaabaaabaaa
        baabbaaaaaaabaaaaaaaabab
        aaaaabaabbabababbbbabaaa
        aabbbaabbabbabaababbbbababbbababbaaaabbabbabbaaababbabbb
        bbbbabbabaabbaabbbaaababaaabbabbbbabbaaababaabbababbabba
        abaaabbbaaaaabaababbbaaa
        aaaabbbaaabababbbabbababbbabababbbabbabbababbbaa
        baaaaabbbabaabbbabbbbaab
        ababbbaabbabbaabbbbaaaabbbabbaabaababbabbaaaaaaaaaaaabbbbbaabbbaaaabaaab
        baababbabbbbbaaabbaabbba
        baaabbaabbaabaaaabbbabaa
        baabbaabaaabbbbbbabbabaaaaabaaba
        aabbabbbbbababbbbbabbaab
        bbabbbaaabbaaabbaaabababaaaaabbbbaaabbba
        baabaaaabaaabaabbaabbaaaaabbaaabaabbaabb
        baabaaaabbbaaaabbbaaabaa
        aaabbbbbbabaaaaaaaababbababaabbbbabababbbababbbbbaaaaaba
        bbabaaabbabbbbbbbaababbaabbaabbb
        baabbabbbbbbbbbbbaaaabba
        abaaababbbabbabaabaababb
        bbbabbbbaababababaababab
        bbbbbaaababaaaaaaabaababbbbabbbabbaaaaab
        aabbbaabaaaaabbbbbabbaaa
        aaabaaaababbaabbaabbaaaabbbbaabbbbaabbaa
        abababbaaabbbabbabbbabaa
        aabbbababbaaaabbaaaaaaabbbaababbbabbbabaabbbabababbaabab
        bababbaabababbaabbbbbbba
        bbababababbaabaaaaaaaaaa
        ababbbbbaabbabababaabaab
        bbbabbbabbabbaabbabbbabbabaaabbabbaaabbabbbbabaa
        bbabaaabbbbbbaaaaabbbabbabbaababbbbbbabbabbbbbbbaaaaaaaa
        ababaaababbabbaabbabbababbaaaaab
        abbbbbababababbbabaabaaabaaabababbabbaba
        abaabababaabbaaabbaababbbaaaabbaabaaababbbbbaaababbaaaaaaabbabbababbbaba
        bbbaaabababaaaaabaabbabbaabbaaabbaaaababaaabaabbbaabbabb
        abbabaabababaabbbbaaabbb
        aabbbaabbaabaaaabababaaa
        abaabbabaaaaaaababbbaaababaaaaaaabbbbaaabaaaaaaabaabbbba
        abbaabbabaabbaaabbabbaaa
        bbbbabbbabaababbbbababaa
        babbbbabbbbaaaaabbbaabab
        aabbababbabbbbbbbbaaaaab
        babaaabaaabaabbabababbbbabbabbbb
        aaabababbbbababbbbbaabaa
        aababbbbabbbbabbaabbbaaa
        abaaabbbbabbababbaabaaba
        abbbbaaaababaababbbbbaababbbabbabaaaabbabaaabaaababbbaab
        abbaabaaaaaabaabbbbaaaba
        abaabbbbbbaaababbaabbabaababaaababaabbabaaabaaababaaaaba
        aabbbabbbaaabaabbbaaabaa
        abbbbabbaabbbbaaabaaaababaabbbba
        aaaabababbbbaabbabbaabbb
        abaabbabbbbabbaababaabbaabababab
        aaababbababbbbbbbaababaa
        aaaabbbaaababababaaababbbbaabbbaabbbbbaa
        aababbababaabbbbabbaaaabaabbaabaaabaabaabbbbabbaababababaaabbbabbbbbabaabbbaabababaaabba
        baaabbbbbbbbabbabbabbaab
        bbabbbabbabaaaaaabababbaabbaabaaabbabbaabaababaabaabbbaa
        baabbaabaaabbabbaaabaaaabaaaaababbaaabaa
        abbaaabbbabaaaaabbbabaaa
        bbabaaabbabbaababababaaa
        bbbabbbbabbbaabbbbabaabb
        abbaaabaabaaababbbaabbabbbbaabaaabbbbbaabaabaabb
        aaabbabbbbbabbbbaabbababbabbabaabaabbbaabaaababa
        baaabbaabaababbabbbbaaba
        bbbbbababaabbaababaaaaba
        baaabbaabbbaabbbaababaaabbbabaababbabbbb
        abaabbbbabbbabbbbaaaabbb
        bbbabbbbbabbababaaabaabb
        baaababbbbbbbaabaabbbbabbabbaababbababbaabbaabbb
        aababbbaaabbbbbbaababbaabbaababbbaaabababbaabbbbbabababaaabaabbaababbbbb
        bbbbbbbbbbaaaababaaabbbbabaababbbabbaaab
        aababbbbabbaabbabaaabaaa
        abbbbabbbbabababaabbaaab
        bbabaababbbbbbaaababaabbbbbabaababaaaaabbbabbbababbbbbaa
        bbbaabaabbbbbaabbbaabaab
        aabbbbbbbbbbbbbbbbababbaaababbbaaaabaabb
        aabbbabababababaaabaababaaabbabbaabbbababbabbabaabaaabba
        abaababbbbbbabbababbaaab
        babbbbabbbaababbbbbbbbaa
        aaabbaaabbbbabaabbaabaab
        bbababbabaababbaabbbaabb
        abbaabaabbbaabaabbbbbaabbbbbaaba
        bbbaabaaabbabaabbbabaaaababbbaba
        ababaababbababbbbbbbababbabbabbaabbbaabaabaabaaa
        baaaaaababaaabaaabaababa
        ababaababbbaabaabaababab
        aabbbbbbbbabbabbabbaabbb
        abaabbbbbbabbabaaabaaaaa
        bbbbbaabaabababaabbaaaabababaabbaabbaabbabbbabab
        abbaaabaabaaababbaabaaab
        bbbbbbabbaaaaaabaabaabaabbbaaaabbbaabbbb
        babaaaaaaabbbbbbabababbb
        abaaaaaaabbababbbbbbaaaa
        bbbbabbbbaabbaaaabbbabbbabaaaaababaabaaa
        aaaaabaabababbabbbaaaaab
        abbababbbaaabbabbaabaabbaabbababbbaaabbbbbbbbbaabbbabaab
        abbabbaabbabbbababaabaaa
        baabbaabbbbbbbbbbbbaaaba
        aaaaababaaabaaaaabbbaabbabaaabaabaabbabbaabaaabababbababababaaabbabaabba
        bbabaababbbaaabbaaaaaabbbaaababa
        aaabaaaaaaaaabaaaabbabaa
        abbbabbbaababbbababaaaab
        aabbbbabaabbbbaaabbbbaaaaabbbabaaabababaaaaaaaaa
        baaaaaabbaaababbababaababbbaabbb
        baabbbbbbbbbbababbaabaaabbabbaaaabbabbbb
        baaabbabbaabbbbbbbbbbabaabbbabaabaabbbabbbbabbbababbbaba
        abbbbaaabbababbbababbbabbbbbbaaaaabbaaababaaaaabbbaabbbb
        aaaaabaaaaaabbbaababbbabbbabbbba
        bbbbabbbaabababaaaabbaab
        baabaaaabababbabbaaabbba
        bbaabaaaaabbababaabbabaa
        aabbababbbaaaabaaaaaabbbaaaaabbaababbaba
        abbbaabbbbaaaabababbbaab
        abaaababababaabbbbaabbba
        aabbaaababaabbaabbabbbbababaaaabbaaaaaba
        bbbbbbbbbbbbbaaaabbbbababbaaaababbbbbaabaaabbaabbabbaaababbbbbbaabbbabab
        abbabababbabbbbaaabaaabbaabbabba
        aaabbbbaababbabbbbabbbab
        bbbaaaaaabbbbaaaaabaabbabaaababbababbaab
        bbbababbbbbbbaaaaabbabba
        bbaaaabbbbbbbbbbaaaaabbbbbbabbbaaabababb
        aaabbbbaaaaaaabbbaabbaabbaabbabbaabaabaabaaaabaabababaabbbbabaaa
        abababbabbababbaabbababbbabbbaba
        aabbbabbabbbaaabaabbbaaa
        baaabbaabbbaaaabbaabaaab
        baabaaaabbbbbababaabaababbabaaabbbbabbbbbbaaabbbbaaaaaaabbbaabbb
        bbabaaabbbabbababababababaaaabab
        babababaabbbabaabbbaaaba
        abbaabaabbabaabaaababbab
        bbaaaababaaabbaaabaaabba
        bbabbbbbaaabbbbaaaabbaba
        aabaabababaabbbbababbaaa
        babaabbbbbababbaaababbab
        abbbbbbbbaaabbbababbbbbabababbbb
        babbabaabbbbbaabbbbbbbba
        abbbaabbaabbbaabaabbabaa
        aaaaaabaaabaabbabbaaaabbaabaabbbbbbabbab
        bbbaaabbaaabababaabbbaaa
        bbbaaaaaaabbbabbaabbaaab
        abaaaaaabbbbaabbbbabaaaaaabaabbbaaaaabbbbbaaaaaa
    """.trimIndent())
    check(205, result)
}

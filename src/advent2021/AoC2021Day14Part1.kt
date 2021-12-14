package advent2021

private var result = 0

fun main() {
    result = test(
        "NNCB", """
            CH -> B
            HH -> N
            CB -> H
            NH -> C
            HB -> C
            HC -> B
            HN -> C
            NN -> C
            BH -> H
            NC -> B
            NB -> B
            BN -> B
            BB -> N
            BC -> B
            CC -> N
            CN -> C
    """.trimIndent()
    )
    check(1588, result)

    result = test(
        "BSONBHNSSCFPSFOPHKPK", """
            PF -> P
            KO -> H
            CH -> K
            KN -> S
            SS -> K
            KB -> B
            VS -> V
            KV -> O
            KP -> B
            OF -> C
            HB -> C
            NP -> O
            NS -> V
            VO -> P
            VF -> H
            CK -> B
            PC -> O
            SK -> O
            KF -> H
            FV -> V
            PP -> H
            KS -> B
            FP -> N
            BV -> V
            SB -> F
            PB -> B
            ON -> F
            SF -> P
            VH -> F
            FC -> N
            CB -> H
            HP -> B
            NC -> B
            FH -> K
            BF -> P
            CN -> N
            NK -> H
            SC -> S
            PK -> V
            PV -> C
            KC -> H
            HN -> K
            NO -> H
            NN -> S
            VC -> P
            FF -> N
            OO -> H
            BK -> N
            FS -> V
            BO -> F
            SH -> S
            VK -> F
            OC -> F
            FN -> V
            OV -> K
            CF -> F
            NV -> V
            OP -> K
            PN -> K
            SO -> P
            PS -> S
            KK -> H
            HH -> K
            NH -> O
            FB -> K
            HS -> B
            BB -> V
            VB -> O
            BH -> H
            OK -> C
            CC -> B
            FK -> N
            SN -> V
            HK -> N
            KH -> F
            OS -> O
            FO -> P
            OH -> B
            CP -> S
            BN -> H
            OB -> B
            BP -> B
            CO -> K
            SP -> K
            BS -> P
            VV -> N
            VN -> O
            NF -> F
            CV -> B
            HC -> B
            HV -> S
            BC -> O
            HO -> H
            PO -> P
            CS -> B
            PH -> S
            SV -> V
            VP -> C
            NB -> K
            HF -> C
    """.trimIndent()
    )
    check(2740, result)
}

private fun test(initial: String, input: String): Int {
    val commands = input.split("\n").map {
        val (from, to) = it.split(" -> ")
        from to to
    }

    var s = initial

    for (step in 1..10) {
        var i = 0
        while (i < s.lastIndex) {
            val from = "" + s[i] + s[i + 1]
            val to = commands.find { it.first == from }?.second
            if (to != null) {
                s = StringBuilder(s).insert(i + 1, to).toString()
                ++i
            }
            ++i
        }
        println(s)
    }

    val map = mutableMapOf<Char, Int>()
    for (ch in s) {
        map.putIfAbsent(ch, 0)
        map.computeIfPresent(ch) { _, v -> v + 1 }
    }

    return map.maxBy { (_, v) -> v }!!.value - map.minBy { (_, v) -> v }!!.value
}

package advent2021

private var result = 0L

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
    check(2188189693529, result)

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
    check(2959788056211, result)
}

private fun test(initial: String, input: String): Long {
    val commands = input.split("\n").map {
        val (from, to) = it.split(" -> ")
        from to to.first()
    }.toMap()

    var map = mutableMapOf<Pair<Char, Char>, Long>()
    for (i in 0 until initial.lastIndex) {
        val pair = initial[i] to initial[i + 1]
        incL(map, pair)
    }

    for (step in 1..40) {
        val newMap = mutableMapOf<Pair<Char, Char>, Long>()
        for (entry in map.entries) {
            val from = "" + entry.key.first + entry.key.second
            val to = commands[from]!!
            incL(newMap, entry.key.first to to, entry.value)
            incL(newMap, to to entry.key.second, entry.value)
        }
        map = newMap
    }

    val counts = mutableMapOf<Char, Long>()
    for ((from, to) in map.entries) {
        incL(counts, from.first, to)
        incL(counts, from.second, to)
    }

    counts[initial.first()] = counts[initial.first()]!! + 1
    counts[initial.last()] = counts[initial.last()]!! + 1

    return (counts.maxBy { (_, v) -> v }!!.value - counts.minBy { (_, v) -> v }!!.value) / 2
}

private fun <K> incL(map: MutableMap<K, Long>, k: K, d: Long = 1) {
    map.putIfAbsent(k, 0)
    map.computeIfPresent(k) { _, v -> v + d }
}

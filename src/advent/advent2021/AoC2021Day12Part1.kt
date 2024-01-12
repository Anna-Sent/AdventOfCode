package advent.advent2021

private var result = 0

fun main() {
    result = test(
            """
            start-A
            start-b
            A-c
            A-b
            b-d
            A-end
            b-end
    """.trimIndent()
    )
    check(10, result)

    result = test(
            """
            dc-end
            HN-start
            start-kj
            dc-start
            dc-HN
            LN-dc
            HN-end
            kj-sa
            kj-HN
            kj-dc
    """.trimIndent()
    )
    check(19, result)

    result = test(
            """
                fs-end
                he-DX
                fs-he
                start-DX
                pj-DX
                end-zg
                zg-sl
                zg-pj
                pj-he
                RW-he
                fs-DX
                pj-RW
                zg-RW
                start-pj
                he-WI
                zg-he
                pj-fs
                start-RW
    """.trimIndent()
    )
    check(226, result)

    result = test(
            """
                yb-pi
                jg-ej
                yb-KN
                LD-start
                end-UF
                UF-yb
                yb-xd
                qx-yb
                xd-end
                jg-KN
                start-qx
                start-ej
                qx-LD
                jg-LD
                xd-LD
                ej-qx
                end-KN
                DM-xd
                jg-yb
                ej-LD
                qx-UF
                UF-jg
                qx-jg
                xd-UF
    """.trimIndent()
    )
    check(4011, result)
}

private fun test(input: String): Int {
    val tokens = input.split("\n")

    val map = mutableMapOf<String, MutableList<String>>()
    for (token in tokens) {
        val (f, s) = token.split("-")
        map.putIfAbsent(f, mutableListOf())
        map.computeIfPresent(f) { _, v ->
            v += s
            v
        }
        map.putIfAbsent(s, mutableListOf())
        map.computeIfPresent(s) { _, v ->
            v += f
            v
        }
    }

    val paths = mutableListOf<MutableList<String>>()
    find(mutableListOf("start"), map, paths)
    return paths.size
}

private fun find(current: MutableList<String>,
                 map: Map<String, MutableList<String>>,
                 paths: MutableList<MutableList<String>>) {
    for (p in map[current.last()]!!) {
        if (p.isSmall() && p in current) {
            continue
        }
        val newCurrent = mutableListOf<String>()
        newCurrent += current
        newCurrent += p
        if (p == "end") {
            paths += newCurrent
        } else {
            find(newCurrent, map, paths)
        }
    }
}

private fun String.isSmall() = this[0] in 'a'..'z'

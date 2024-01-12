package advent.advent2020

private fun test(pk1: Long, pk2: Long): Long {
    val d = findLoopSize(pk2)
    return calcPk(pk1, d)
}

private const val GENERATOR = 20201227L

private fun findLoopSize(pk: Long): Long {
    var probablePk = 1L
    for (i in 1..GENERATOR) {
        probablePk *= 7
        probablePk %= GENERATOR
        if (probablePk == pk) {
            return i
        }
    }
    return -1
}

private fun calcPk(subject: Long, loopSize: Long): Long {
    var pk = 1L
    for (i in 1..loopSize) {
        pk *= subject
        pk %= GENERATOR
    }
    return pk
}

fun main() {
    test()
}

private var result: Long = 0

private fun test() {
    result = test(5764801, 17807724)
    check(14897079, result)

    result = test(14788856, 19316454)
    check(545789, result)
}

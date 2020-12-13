package advent2020

import java.math.BigInteger

private fun test(input: String): Long {
    val aList = mutableListOf<BigInteger>()
    val rList = mutableListOf<BigInteger>()

    var count = 0
    input.split(",").withIndex().forEach {
        val id = it.value.toIntOrNull()
        if (id != null) {
            aList += BigInteger.valueOf(id.toLong())
            rList += BigInteger.valueOf((id - it.index).toLong())
            ++count
        }
    }

    var m = BigInteger.ONE
    aList.forEach { a -> m = m.multiply(a) }

    var sum = BigInteger.ZERO
    for (i in 0 until count) {
        val a = aList[i]
        val r = rList[i]
        val mi = m.div(a)
        val miInv = mi.modInverse(a)
        sum = sum.add(mi.multiply(miInv).multiply(r))
    }

    return sum.mod(m).toLong()
}

fun main() {
    test()
}

private var result: Long = 0

private fun test() {
    result = test("7,13,x,x,59,x,31,19")
    check(1068781, result)

    result = test("17,x,13,19")
    check(3417, result)

    result = test("67,7,59,61")
    check(754018, result)

    result = test("67,x,7,59,61")
    check(779210, result)

    result = test("67,7,x,59,61")
    check(1261476, result)

    result = test("1789,37,47,1889")
    check(1202161486, result)

    result = test("17,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,643,x,x,x,x,x,x,x,23,x,x,x,x,13,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,29,x,433,x,x,x,x,x,37,x,x,x,x,x,x,x,x,x,x,x,x,19")
    check(760171380521445, result)
}

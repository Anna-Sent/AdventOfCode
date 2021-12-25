package advent2021

import java.util.*

private var result = 0L

fun main() {
    result = test(
        """
            inp w
            mul x 0
            add x z
            mod x 26
            div z 1
            add x 11
            eql x w
            eql x 0
            mul y 0
            add y 25
            mul y x
            add y 1
            mul z y
            mul y 0
            add y w
            add y 1
            mul y x
            add z y
            inp w
            mul x 0
            add x z
            mod x 26
            div z 1
            add x 11
            eql x w
            eql x 0
            mul y 0
            add y 25
            mul y x
            add y 1
            mul z y
            mul y 0
            add y w
            add y 11
            mul y x
            add z y
            inp w
            mul x 0
            add x z
            mod x 26
            div z 1
            add x 14
            eql x w
            eql x 0
            mul y 0
            add y 25
            mul y x
            add y 1
            mul z y
            mul y 0
            add y w
            add y 1
            mul y x
            add z y
            inp w
            mul x 0
            add x z
            mod x 26
            div z 1
            add x 11
            eql x w
            eql x 0
            mul y 0
            add y 25
            mul y x
            add y 1
            mul z y
            mul y 0
            add y w
            add y 11
            mul y x
            add z y
            inp w
            mul x 0
            add x z
            mod x 26
            div z 26
            add x -8
            eql x w
            eql x 0
            mul y 0
            add y 25
            mul y x
            add y 1
            mul z y
            mul y 0
            add y w
            add y 2
            mul y x
            add z y
            inp w
            mul x 0
            add x z
            mod x 26
            div z 26
            add x -5
            eql x w
            eql x 0
            mul y 0
            add y 25
            mul y x
            add y 1
            mul z y
            mul y 0
            add y w
            add y 9
            mul y x
            add z y
            inp w
            mul x 0
            add x z
            mod x 26
            div z 1
            add x 11
            eql x w
            eql x 0
            mul y 0
            add y 25
            mul y x
            add y 1
            mul z y
            mul y 0
            add y w
            add y 7
            mul y x
            add z y
            inp w
            mul x 0
            add x z
            mod x 26
            div z 26
            add x -13
            eql x w
            eql x 0
            mul y 0
            add y 25
            mul y x
            add y 1
            mul z y
            mul y 0
            add y w
            add y 11
            mul y x
            add z y
            inp w
            mul x 0
            add x z
            mod x 26
            div z 1
            add x 12
            eql x w
            eql x 0
            mul y 0
            add y 25
            mul y x
            add y 1
            mul z y
            mul y 0
            add y w
            add y 6
            mul y x
            add z y
            inp w
            mul x 0
            add x z
            mod x 26
            div z 26
            add x -1
            eql x w
            eql x 0
            mul y 0
            add y 25
            mul y x
            add y 1
            mul z y
            mul y 0
            add y w
            add y 15
            mul y x
            add z y
            inp w
            mul x 0
            add x z
            mod x 26
            div z 1
            add x 14
            eql x w
            eql x 0
            mul y 0
            add y 25
            mul y x
            add y 1
            mul z y
            mul y 0
            add y w
            add y 7
            mul y x
            add z y
            inp w
            mul x 0
            add x z
            mod x 26
            div z 26
            add x -5
            eql x w
            eql x 0
            mul y 0
            add y 25
            mul y x
            add y 1
            mul z y
            mul y 0
            add y w
            add y 1
            mul y x
            add z y
            inp w
            mul x 0
            add x z
            mod x 26
            div z 26
            add x -4
            eql x w
            eql x 0
            mul y 0
            add y 25
            mul y x
            add y 1
            mul z y
            mul y 0
            add y w
            add y 8
            mul y x
            add z y
            inp w
            mul x 0
            add x z
            mod x 26
            div z 26
            add x -8
            eql x w
            eql x 0
            mul y 0
            add y 25
            mul y x
            add y 1
            mul z y
            mul y 0
            add y w
            add y 6
            mul y x
            add z y
    """.trimIndent()
    )
    check(92969593497992, result)
}

private const val REGISTER = "(w|x|y|z)"
private const val REGISTER_OR_NUMBER = "(w|x|y|z|-?\\d+)"

private val inp = "inp $REGISTER".toPattern()
private val add = "add $REGISTER $REGISTER_OR_NUMBER".toPattern()
private val mul = "mul $REGISTER $REGISTER_OR_NUMBER".toPattern()
private val div = "div $REGISTER $REGISTER_OR_NUMBER".toPattern()
private val mod = "mod $REGISTER $REGISTER_OR_NUMBER".toPattern()
private val eql = "eql $REGISTER $REGISTER_OR_NUMBER".toPattern()

private fun test(input: String): Long {
    val commands = input.split("\n")

    val parts = mutableListOf<MutableList<String>>()
    for (command in commands) {
        if (inp.matcher(command).matches()) {
            parts += mutableListOf<String>()
        } else {
            parts.last() += command
        }
    }

    val stack = Stack<Pair<Int, Int>>()
    val constraints = mutableMapOf<Int, Pair<Int, Int>>()
    for ((index, part) in parts.withIndex()) {
        var matcher = div.matcher(part[3])
        if (matcher.matches()) {
            var arg = matcher.group(2).toInt()
            if (arg == 1) {
                matcher = add.matcher(part[14])
                if (matcher.matches()) {
                    arg = matcher.group(2).toInt()
                    stack.push(index to arg)
                } else throw IllegalArgumentException("no match add 14")
            } else {
                val (index1, arg1) = stack.pop()
                matcher = add.matcher(part[4])
                if (matcher.matches()) {
                    val arg2 = matcher.group(2).toInt()
                    constraints[index] = arg1 + arg2 to index1
                } else throw IllegalArgumentException("no match add 4")
            }
        } else throw IllegalArgumentException("no match div 3")
    }

    val results = mutableListOf<Long>()
    solve(results, emptyList(), constraints)
    return results.max()!!
}

private fun solve(results: MutableList<Long>, numbers: List<Int>, constraints: Map<Int, Pair<Int, Int>>) {
    if (numbers.size == 14) {
        results.add(numbers.map { it.toString() }.reduce { a, b -> a + b }.toLong())
        return
    }

    if (numbers.size in constraints) {
        val (delta, index) = constraints[numbers.size]!!
        val digit = numbers[index] + delta
        if (digit in 1..9) solve(results, numbers + digit, constraints)
        return
    }

    for (i in 1..9) {
        solve(results, numbers + i, constraints)
    }
}

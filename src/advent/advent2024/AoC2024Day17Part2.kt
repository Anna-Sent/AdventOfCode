package advent.advent2024

import kotlin.math.pow

private var result = 0L

fun main() {
    result = test(
        """
            Register A: 21539243
            Register B: 0
            Register C: 0

            Program: 2,4,1,3,7,5,1,5,0,3,4,1,5,5,3,0
    """.trimIndent()
    )
    check(216549846240877, result)
}

private fun test(input: String): Long {
    val (str1, str2) = input.split("\n\n")
    val (token1, token2, token3) = str1.split("\n")
    var a = token1.removePrefix("Register A: ").toLong()
    var b = token2.removePrefix("Register B: ").toLong()
    var c = token3.removePrefix("Register C: ").toLong()
    val program = str2.removePrefix("Program: ").split(",").map(String::toLong)
    val initialB = b
    val initialC = c

    fun runProgram(print: Boolean): List<Long> {
        var pointer = 0
        val out = mutableListOf<Long>()

        fun combo(operand: Long): Long = when (operand) {
            in 0..3 -> operand
            4L -> a
            5L -> b
            6L -> c
            else -> throw IllegalStateException("illegal combo operand $operand")
        }

        fun comboStr(operand: Long): String = when (operand) {
            in 0..3 -> operand.toString()
            4L -> "a"
            5L -> "b"
            6L -> "c"
            else -> throw IllegalStateException("illegal combo operand $operand")
        }

        fun literal(operand: Long): Long = when (operand) {
            in 0..7 -> operand
            else -> throw IllegalStateException("illegal literal operand $operand")
        }

        while (pointer < program.size) {
            val opcode = program[pointer]
            val operand = program[pointer + 1]
            when (opcode) {
                0L -> {
                    //adv
                    a = (a / 2.0.pow(combo(operand).toDouble())).toLong()
                    if (print) println("a = a / 2 ^ ${comboStr(operand)}")
                }

                1L -> {
                    //bxl
                    b = b xor literal(operand)
                    if (print) println("b = b xor ${literal(operand)}")
                }

                2L -> {
                    //bst
                    b = combo(operand) % 8
                    if (print) println("b = ${comboStr(operand)} % 8")
                }

                3L -> {
                    //jnz
                    if (a != 0L) {
                        pointer = literal(operand).toInt()
                        if (print) println("jump ${literal(operand)}")
                        continue
                    }
                }

                4L -> {
                    //bxc
                    b = b xor c
                    if (print) println("b = b xor c")
                }

                5L -> {
                    //out
                    out += combo(operand) % 8
                    if (print) println("out ${comboStr(operand)} % 8")
                }

                6L -> {
                    // bdv
                    b = (a / 2.0.pow(combo(operand).toDouble())).toLong()
                    if (print) println("b = a / 2 ^ ${comboStr(operand)}")
                }

                7L -> {
                    //cdv
                    c = (a / 2.0.pow(combo(operand).toDouble())).toLong()
                    if (print) println("c = a / 2 ^ ${comboStr(operand)}")
                }

                else -> throw IllegalStateException("illegal opcode $opcode")
            }
            pointer += 2
        }

        return out
    }

    fun runSimplifiedProgram1(): List<Long> {
        val out = mutableListOf<Long>()
        while (a != 0L) {
            b = (a % 8) xor 3
            var pow = 1
            for (i in 1..b) pow *= 2
            c = a / pow
            b = (b xor 5) xor c
            out += b % 8
            a /= 8
        }
        return out
    }

    fun runSimplifiedProgram2(): List<Long> {
        val out = mutableListOf<Long>()
        while (a != 0L) {
            b = (a % 8) xor 3
            c = a shr b.toInt()
            b = (b xor 5) xor c
            out += b % 8
            a /= 8
        }
        return out
    }

    fun runSimplifiedProgram3(): List<Long> {
        val out = mutableListOf<Long>()
        while (a != 0L) {
            out += ((((a % 8) xor 3) xor 5) xor (a shr ((a % 8).toInt() xor 3))) % 8
            a /= 8
        }
        return out
    }

    fun runIteration(a: Long): Long {
        return ((((a % 8) xor 3) xor 5) xor (a shr ((a % 8).toInt() xor 3))) % 8
    }

    fun findA(index: Int, A: Long): Long {
        if (index < 0) return A
        for (Ai in 0..7) {
            if (runIteration(8 * A + Ai) == program[index]) {
                val result = findA(index - 1, 8 * A + Ai)
                if (result == -1L) continue
                else return result
            }
        }
        return -1
    }

    val initialA = findA(15, 0)

    a = initialA
    b = initialB
    c = initialC
    var out = runProgram(false)
    check(program.joinToString(","), out.joinToString(","))

    a = initialA
    b = initialB
    c = initialC
    out = runSimplifiedProgram1()
    check(program.joinToString(","), out.joinToString(","))

    a = initialA
    b = initialB
    c = initialC
    out = runSimplifiedProgram2()
    check(program.joinToString(","), out.joinToString(","))

    a = initialA
    out = runSimplifiedProgram3()
    check(program.joinToString(","), out.joinToString(","))

    return initialA
}

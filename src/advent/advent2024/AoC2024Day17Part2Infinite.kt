package advent.advent2024

import kotlin.math.pow

private var result = 0

fun main() {
    result = test(
        """
            Register A: 2024
            Register B: 0
            Register C: 0

            Program: 0,3,5,4,3,0
    """.trimIndent()
    )
    check(117440, result)

    result = test(
        """
            Register A: 21539243
            Register B: 0
            Register C: 0

            Program: 2,4,1,3,7,5,1,5,0,3,4,1,5,5,3,0
    """.trimIndent()
    )
    check(0, result)
}

private fun test(input: String): Int {
    val (str1, str2) = input.split("\n\n")
    val (token1, token2, token3) = str1.split("\n")
    var a = token1.removePrefix("Register A: ").toInt()
    var b = token2.removePrefix("Register B: ").toInt()
    var c = token3.removePrefix("Register C: ").toInt()
    val program = str2.removePrefix("Program: ").split(",").map(String::toInt)
    val initialB = b
    val initialC = c

    fun runProgram(): List<Int> {
        var pointer = 0
        val out = mutableListOf<Int>()

        fun combo(operand: Int): Int = when (operand) {
            in 0..3 -> operand
            4 -> a
            5 -> b
            6 -> c
            else -> throw IllegalStateException("illegal combo operand $operand")
        }

        fun literal(operand: Int): Int = when (operand) {
            in 0..7 -> operand
            else -> throw IllegalStateException("illegal literal operand $operand")
        }

        while (pointer < program.size) {
            val opcode = program[pointer]
            val operand = program[pointer + 1]
            when (opcode) {
                0 -> {
                    //adv
                    a = (a / 2.0.pow(combo(operand))).toInt()
                }

                1 -> {
                    //bxl
                    b = b xor literal(operand)
                }

                2 -> {
                    //bst
                    b = combo(operand) % 8
                }

                3 -> {
                    //jnz
                    if (a != 0) {
                        pointer = literal(operand)
                        continue
                    }
                }

                4 -> {
                    //bxc
                    b = b xor c
                }

                5 -> {
                    //out
                    out += combo(operand) % 8
                }

                6 -> {
                    // bdv
                    b = (a / 2.0.pow(combo(operand))).toInt()
                }

                7 -> {
                    //cdv
                    c = (a / 2.0.pow(combo(operand))).toInt()
                }

                else -> throw IllegalStateException("illegal opcode $opcode")
            }
            pointer += 2
        }

        return out
    }

    for (initialA in 1..Int.MAX_VALUE) {
        a = initialA
        b = initialB
        c = initialC
        val out = runProgram()
        if (out == program) return initialA
    }

    return 0
}

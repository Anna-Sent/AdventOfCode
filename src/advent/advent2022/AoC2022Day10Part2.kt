package advent.advent2022

import kotlin.math.abs

fun main() {
    test("""
        addx 15
        addx -11
        addx 6
        addx -3
        addx 5
        addx -1
        addx -8
        addx 13
        addx 4
        noop
        addx -1
        addx 5
        addx -1
        addx 5
        addx -1
        addx 5
        addx -1
        addx 5
        addx -1
        addx -35
        addx 1
        addx 24
        addx -19
        addx 1
        addx 16
        addx -11
        noop
        noop
        addx 21
        addx -15
        noop
        noop
        addx -3
        addx 9
        addx 1
        addx -3
        addx 8
        addx 1
        addx 5
        noop
        noop
        noop
        noop
        noop
        addx -36
        noop
        addx 1
        addx 7
        noop
        noop
        noop
        addx 2
        addx 6
        noop
        noop
        noop
        noop
        noop
        addx 1
        noop
        noop
        addx 7
        addx 1
        noop
        addx -13
        addx 13
        addx 7
        noop
        addx 1
        addx -33
        noop
        noop
        noop
        addx 2
        noop
        noop
        noop
        addx 8
        noop
        addx -1
        addx 2
        addx 1
        noop
        addx 17
        addx -9
        addx 1
        addx 1
        addx -3
        addx 11
        noop
        noop
        addx 1
        noop
        addx 1
        noop
        noop
        addx -13
        addx -19
        addx 1
        addx 3
        addx 26
        addx -30
        addx 12
        addx -1
        addx 3
        addx 1
        noop
        noop
        noop
        addx -9
        addx 18
        addx 1
        addx 2
        noop
        noop
        addx 9
        noop
        noop
        noop
        addx -1
        addx 2
        addx -37
        addx 1
        addx 3
        noop
        addx 15
        addx -21
        addx 22
        addx -6
        addx 1
        noop
        addx 2
        addx 1
        noop
        addx -10
        noop
        noop
        addx 20
        addx 1
        addx 2
        addx 2
        addx -6
        addx -11
        noop
        noop
        noop
    """.trimIndent())
    println()
    val input = """
        addx 1
        noop
        addx 29
        addx -24
        addx 4
        addx 3
        addx -2
        addx 3
        addx 1
        addx 5
        addx 3
        addx -2
        addx 2
        noop
        noop
        addx 7
        noop
        noop
        noop
        addx 5
        addx 1
        noop
        addx -38
        addx 21
        addx 8
        noop
        addx -19
        addx -2
        addx 2
        addx 5
        addx 2
        addx -12
        addx 13
        addx 2
        addx 5
        addx 2
        addx -18
        addx 23
        noop
        addx -15
        addx 16
        addx 7
        noop
        noop
        addx -38
        noop
        noop
        noop
        noop
        noop
        noop
        addx 8
        addx 2
        addx 3
        addx -2
        addx 4
        noop
        noop
        addx 5
        addx 3
        noop
        addx 2
        addx 5
        noop
        noop
        addx -2
        noop
        addx 3
        addx 6
        noop
        addx -38
        addx -1
        addx 35
        addx -6
        addx -19
        addx -2
        addx 2
        addx 5
        addx 2
        addx 3
        noop
        addx 2
        addx 3
        addx -2
        addx 2
        noop
        addx -9
        addx 16
        noop
        addx 9
        addx -3
        addx -36
        addx -2
        addx 11
        addx 22
        addx -28
        noop
        addx 3
        addx 2
        addx 5
        addx 2
        addx 3
        addx -2
        addx 2
        noop
        addx 3
        addx 2
        noop
        addx -11
        addx 16
        addx 2
        addx 5
        addx -31
        noop
        addx -6
        noop
        noop
        noop
        noop
        noop
        addx 7
        addx 30
        addx -24
        addx -1
        addx 5
        noop
        noop
        noop
        noop
        noop
        addx 5
        noop
        addx 5
        noop
        addx 1
        noop
        addx 2
        addx 5
        addx 2
        addx 1
        noop
        noop
        noop
        noop
    """.trimIndent()
    test(input)
    test(input, dark = "\u2588", lit = "\u00A0")
}

private fun test(input: String, dark: String = "#", lit: String = ".") {

    var x = 1
    var cycle = 0
    var position = 0

    fun printPixel() {
        if (abs(position - x) <= 1) {
            print(dark)
        } else {
            print(lit)
        }
    }

    fun runCycle() {
        ++cycle
        if (cycle % 40 == 0) {
            printPixel()
            println()
            position = 0
        } else {
            printPixel()
            ++position
        }
    }

    for (line in input.split("\n")) {
        if (line == "noop") {
            runCycle()
        } else {
            val num = line.replace("addx ", "").toInt()
            runCycle()
            runCycle()
            x += num
        }
    }
}

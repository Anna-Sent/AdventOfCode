package advent2021

import utils.Point
import kotlin.math.abs
import kotlin.math.max

private var result = 0

fun main() {
    result = test(20..30, -10..-5)
    check(112, result)

    result = test(211..232, -124..-69)
    check(2032, result)
}

private fun test(xRange: IntRange, yRange: IntRange): Int {
    val maxX = max(abs(xRange.first), abs(xRange.last))
    val maxY = max(abs(yRange.first), abs(yRange.last))

    var count = 0
    for (xVel in -maxX..maxX) {
        for (yVel in -maxY..maxY) {
            val res = doSteps(xVel, yVel, xRange, yRange)
            if (res.success) {
                ++count
            }
        }
    }

    return count
}

private data class Result2021172(val success: Boolean, val highestY: Int)

private fun doSteps(xVelInitial: Int, yVelInitial: Int, xRange: IntRange, yRange: IntRange): Result2021172 {
    var step = 0
    var current = Point(0, 0)
    var highestY = 0
    println()
    var xVel = xVelInitial
    var yVel = yVelInitial
    println("xVel=$xVel, yVel=$yVel")
    while (true) {
        current = run {
            val p = Point(current.x, current.y)
            p.x += xVel
            p.y += yVel
            p
        }

        if (xVel > 0) {
            --xVel
        } else if (xVel < 0) {
            ++xVel
        }
        --yVel

        ++step

        println("after step $step: $current, xVel=$xVel, yVel=$yVel")

        highestY = max(current.y, highestY)

        if (current.x in xRange && current.y in yRange) {
            return Result2021172(true, highestY)
        }

        if (current.x > xRange.last || current.y < yRange.first) {
            return Result2021172(false, highestY)
        }
    }
}

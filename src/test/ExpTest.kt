package test

import java.util.concurrent.TimeUnit
import kotlin.math.min
import kotlin.math.pow

fun main() {
    test(1_000, 30_000, 55)
    //test(100, 2_000, 55)
}

private fun test(baseDelay: Long, maxDelay: Long, max: Int) {
    var sum = 0L
    for (i in 0..max) {
        val delay = exponentialDelay(i, 1_000, 30_000)
        if (delay > 0) sum += delay
        println("$i => $delay (${TimeUnit.MILLISECONDS.toMinutes(sum)})")
    }
}

private fun exponentialDelay(tryCount: Int, baseDelay: Long, maxDelay: Long): Long =
        min(maxDelay, 2.0.pow(tryCount).toLong() * baseDelay) * (1 + (0..1).random()) / 2

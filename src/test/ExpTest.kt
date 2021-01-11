package test

import java.util.concurrent.TimeUnit
import kotlin.math.min
import kotlin.math.pow
import kotlin.random.Random

fun main() {
    test(1_000, 30_000, 1000)
    test(100, 2_000, 1000)
}

private fun test(baseDelay: Long, maxDelay: Long, max: Int) {
    var sum = 0L
    for (i in 0..max) {
        val delay = exponentialDelay(i, baseDelay, maxDelay)
        if (delay > 0) sum += delay
        println("($baseDelay $maxDelay) $i => $delay (${TimeUnit.MILLISECONDS.toMinutes(sum)})")
    }
}

private fun exponentialDelay(tryCount: Int, baseDelay: Long, maxDelay: Long): Long =
        (min(maxDelay.toDouble(), 2.0.pow(tryCount) * baseDelay) * (1 + Random.nextDouble()) / 2)
                .toLong()

package test.concurrency

import kotlin.concurrent.thread

fun main() {
    var sum = 0
    val threads = mutableListOf<Thread>()
    for (i in 0 until 10000) {
        threads += thread {
            sum += 1
        }
    }
    threads.forEach { it.join() }

    println("sum = $sum")
}

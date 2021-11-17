package test.concurrency

import kotlin.concurrent.thread

private val a = Any()
private val b = Any()

private fun doWork1() {
    synchronized(a) {
        synchronized(b) {
            println("work 1 done")
        }
    }
}

private fun doWork2() {
    synchronized(b) {
        synchronized(a) {
            println("work 2 done")
        }
    }
}

fun main() {
    for (i in 0 until 1000) {
        val t1 = thread { doWork1() }
        val t2 = thread { doWork2() }
        t1.join()
        t2.join()
    }
}

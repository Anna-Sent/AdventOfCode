package coursera.kotlin

fun mySequence() = sequence {
    println("yield one element")
    yield(1)
    println("yield a range")
    yieldAll(3..5)
    println("yield a list")
    yieldAll(listOf(7, 9))
}

fun main() {
    println(mySequence()
            .map { it * it }
            .filter { it > 10 }
            .take(1))
    println(mySequence()
            .map { it * it }
            .filter { it > 10 }
            .first())
}

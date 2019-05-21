package coursera.kotlin_for_java_developers

fun fibonacci(): Sequence<Int> = sequence {
    var prev = 0
    var next = 1
    yield(prev)
    yield(next)
    while (true) {
        val tmp = next
        next += prev
        yield(next)
        prev = tmp
    }
}

fun fibonacci_(): Sequence<Int> = sequence {
    var elements = Pair(0, 1)
    while (true) {
        yield(elements.first)
        elements = elements.second to elements.first + elements.second
    }
}

fun fibonacci__(): Sequence<Int> = sequence {
    var prev = 0
    var next = 1
    while (true) {
        yield(prev)
        val tmp = prev
        prev = next
        next += tmp
    }
}

fun main() {
    fibonacci().take(4).toList().toString() eq
            "[0, 1, 1, 2]"
    fibonacci().take(10).toList().toString() eq
            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"

    fibonacci_().take(4).toList().toString() eq
            "[0, 1, 1, 2]"
    fibonacci_().take(10).toList().toString() eq
            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"

    fibonacci__().take(4).toList().toString() eq
            "[0, 1, 1, 2]"
    fibonacci__().take(10).toList().toString() eq
            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"
}

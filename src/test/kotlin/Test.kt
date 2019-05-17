package test.kotlin

import java.awt.Color

fun main() {
    System.out.println(value(Color.RED))

    val test: String? = null
    test?.let { println("non null") }
}

fun value(color: Color): String {
    return when (color) {
        Color.BLACK -> "black"
        Color.RED -> "red"
        else -> "else"
    }
}

package test.kotlin

import java.awt.Color

fun main() {
    System.out.println(value(Color.RED))
}

fun value(color: Color): String {
    when (color) {
        Color.BLACK -> "black"
        Color.RED -> "red"
        else -> "else"
    }
}

package coursera.kotlin_for_java_developers.test

import java.awt.Color

fun main() {
    System.out.println(value(Color.RED))

    val test: String? = null
    test?.let { println("non null") }

    val mutableList = mutableListOf(1, 2, 3)
    val list: List<Int> = mutableList
    mutableList.add(4)
    println(list)
}

fun value(color: Color): String {
    return when (color) {
        Color.BLACK -> "black"
        Color.RED -> "red"
        else -> "else"
    }
}

package coursera.kotlin_for_java_developers.test

import coursera.kotlin_for_java_developers.A
import coursera.kotlin_for_java_developers.create
//import coursera.kotlin_for_java_developers.AA
import java.awt.Color

fun main() {
    System.out.println(value(Color.RED))

    val test: String? = null
    test?.let { println("non null") }

    val mutableList = mutableListOf(1, 2, 3)
    val list: List<Int> = mutableList
    mutableList.add(4)
    println(list)

    testVisibility()
}

fun testVisibility() {
    val a = A.create() // A("")
    println(a)
    println(A.Nested.a())
    println(A.Companion.test())
    println(A.test())
//    println(a.value)
//    println(AA())
}

fun value(color: Color): String {
    return when (color) {
        Color.BLACK -> "black"
        Color.RED -> "red"
        else -> "else"
    }
}

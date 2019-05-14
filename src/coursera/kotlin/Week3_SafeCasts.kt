package coursera.kotlin

fun main() {
    val s = ""
    println(s as? Int)    // null
    println(s as Int?)    // exception
}

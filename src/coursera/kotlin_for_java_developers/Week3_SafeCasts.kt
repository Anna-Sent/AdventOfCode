package coursera.kotlin_for_java_developers

fun main() {
    val s = ""
    println(s as? Int)    // null
    println(s as Int?)    // exception
}

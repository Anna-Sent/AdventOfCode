package coursera.kotlin_for_java_developers

infix fun Boolean.eq(param: Boolean) {
    System.out.println(if (this == param) "OK" else "FAILED")
}

fun String?.isEmptyOrNull() = this == null || this.isEmpty()

fun main() {
    val s1: String? = null
    val s2: String? = ""
    s1.isEmptyOrNull() eq true
    s2.isEmptyOrNull() eq true

    val s3 = "   "
    s3.isEmptyOrNull() eq false
}

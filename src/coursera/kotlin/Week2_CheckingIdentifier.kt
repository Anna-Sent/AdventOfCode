package coursera.kotlin

fun isValidIdentifier(s: String): Boolean {
    if (s.isEmpty()) return false
    if (s[0].isDigit()) return false
    for (ch in s) {
        if (!isValidChar(ch))
            return false
    }
    return true
}

fun isValidChar(ch: Char) = ch.isLetterOrDigit() || ch == '_'

fun main() {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}

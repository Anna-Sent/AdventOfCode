package coursera.kotlin

fun isValidIdentifier(s: String): Boolean {
    if (s.isEmpty()) return false
    if (isDigit(s[0])) return false
    for (ch in s) {
        if (!isValidChar(ch))
            return false
    }
    return true
}

fun isValidChar(ch: Char) = ch in 'a'..'z' || ch in 'A'..'Z' || isDigit(ch) || ch == '_'

fun isDigit(ch: Char) = ch in '0'..'9'

fun main() {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}

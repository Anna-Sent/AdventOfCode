package coursera.kotlin_for_java_developers

class Words {
    private val list = mutableListOf<String>()

    fun String.record(): Words {
        list += this
        return this@Words
    }

    operator fun Words.plus(s: String) {
        list += s
    }

    override fun toString() = list.toString()
}

fun main() {
    val words = Words()
    with(words) {
        "one".record() + "two"
    }
    words.toString() eq "[one, two]"
}

package advent2020

private fun test(input: String, count: Int): String {
    var numbers = input.map { it.toString().toInt() }.toIntArray()

    val min = numbers.min()!!
    val max = numbers.max()!!
    val size = numbers.size
    val current = 0
    for (i in 1..count) {

        println("move $i")
        println("cups: ${numbers.joinToString(" ")}")
        println("current: ${numbers[current]}")

        val pickedUpIndicies = intArrayOf((current + 1) % size, (current + 2) % size, (current + 3) % size)
        val pickedUpValues = pickedUpIndicies.map { numbers[it] }.toIntArray()

        println("pick up: ${pickedUpValues.joinToString(" ")}")

        var find = numbers[current] - 1
        if (find < min) {
            find = max
        }
        var destination = numbers.find { it == find }!!
        while (pickedUpValues.contains(destination)) {
            --destination
            if (destination < min) {
                destination = max
            }
        }

        println("destination: $destination")
        println()

        val list = mutableListOf<Int>()
        var added = false
        for (number in numbers) {
            if (number !in pickedUpValues) {
                list += number
            }
            if (number == destination) {
                added = true
                list += pickedUpValues.toList()
            }
        }
        if (!added) {
            list += pickedUpValues.toList()
        }

        val head = list[0]
        list.removeAt(0)
        list += head

        numbers = list.toIntArray()
    }

    val result = mutableListOf<Int>()
    var i = 0
    var startAdding = false
    while (result.size != numbers.size - 1) {
        if (numbers[i] == 1) {
            startAdding = true
        } else if (startAdding) {
            result += numbers[i]
        }
        i = (i + 1) % numbers.size
    }

    return result.joinToString("")
}

fun main() {
    test()
}

private var result: String = ""

private fun test() {
    result = test("389125467", 10)
    check("92658374", result)

    result = test("389125467", 100)
    check("67384529", result)

    result = test("123487596", 100)
    check("47598263", result)
}

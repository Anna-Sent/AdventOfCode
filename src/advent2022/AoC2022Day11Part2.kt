package advent2022

private var result = 0L

fun main() {
    result = test("""
Monkey 0:
  Starting items: 79, 98
  Operation: new = old * 19
  Test: divisible by 23
    If true: throw to monkey 2
    If false: throw to monkey 3

Monkey 1:
  Starting items: 54, 65, 75, 74
  Operation: new = old + 6
  Test: divisible by 19
    If true: throw to monkey 2
    If false: throw to monkey 0

Monkey 2:
  Starting items: 79, 60, 97
  Operation: new = old * old
  Test: divisible by 13
    If true: throw to monkey 1
    If false: throw to monkey 3

Monkey 3:
  Starting items: 74
  Operation: new = old + 3
  Test: divisible by 17
    If true: throw to monkey 0
    If false: throw to monkey 1
    """.trimIndent())
    check(2713310158, result)

    result = test("""
Monkey 0:
  Starting items: 74, 73, 57, 77, 74
  Operation: new = old * 11
  Test: divisible by 19
    If true: throw to monkey 6
    If false: throw to monkey 7

Monkey 1:
  Starting items: 99, 77, 79
  Operation: new = old + 8
  Test: divisible by 2
    If true: throw to monkey 6
    If false: throw to monkey 0

Monkey 2:
  Starting items: 64, 67, 50, 96, 89, 82, 82
  Operation: new = old + 1
  Test: divisible by 3
    If true: throw to monkey 5
    If false: throw to monkey 3

Monkey 3:
  Starting items: 88
  Operation: new = old * 7
  Test: divisible by 17
    If true: throw to monkey 5
    If false: throw to monkey 4

Monkey 4:
  Starting items: 80, 66, 98, 83, 70, 63, 57, 66
  Operation: new = old + 4
  Test: divisible by 13
    If true: throw to monkey 0
    If false: throw to monkey 1

Monkey 5:
  Starting items: 81, 93, 90, 61, 62, 64
  Operation: new = old + 7
  Test: divisible by 7
    If true: throw to monkey 1
    If false: throw to monkey 4

Monkey 6:
  Starting items: 69, 97, 88, 93
  Operation: new = old * old
  Test: divisible by 5
    If true: throw to monkey 7
    If false: throw to monkey 2

Monkey 7:
  Starting items: 59, 80
  Operation: new = old + 6
  Test: divisible by 11
    If true: throw to monkey 2
    If false: throw to monkey 3
    """.trimIndent())
    check(19573408701, result)
}

private fun test(input: String): Long {

    val monkeys = arrayListOf<Monkey2>()

    var modulo = 1

    val parts = input.split("\n\n")
    for (part in parts) {
        val lines = part.split("\n")
        val items = lines[1].replace("  Starting items: ", "").split(", ").map { it.toLong() }
        val operation = lines[2].replace("  Operation: new = ", "").replace(" ", "")
        val divisor = lines[3].replace("  Test: divisible by ", "").toInt()
        modulo *= divisor
        val onTrue = lines[4].replace("    If true: throw to monkey ", "").toInt()
        val onFalse = lines[5].replace("    If false: throw to monkey ", "").toInt()
        Monkey2(items.toMutableList(), operation, divisor, onTrue, onFalse).also { monkeys += it }
    }

    for (round in 1..10000) {
        for (monkey in monkeys) {
            for (item in monkey.items) {
                ++monkey.times
                val exp = monkey.operation.replace("old", item.toString())
                val newItem = when {
                    "+" in exp -> {
                        val (o1, o2) = exp.split("+").map { it.toLong() }
                        o1 + o2
                    }

                    "*" in exp -> {
                        val (o1, o2) = exp.split("*").map { it.toLong() }
                        o1 * o2
                    }

                    else -> throw IllegalStateException()
                } % modulo
                if (newItem % monkey.divisor == 0L) {
                    monkeys[monkey.onTrue].items += newItem
                } else {
                    monkeys[monkey.onFalse].items += newItem
                }
            }
            monkey.items.clear()
        }
    }

    monkeys.sortByDescending { it.times }
    val (first, second) = monkeys

    return first.times * second.times
}

private class Monkey2(val items: MutableList<Long>, val operation: String, val divisor: Int, val onTrue: Int, val onFalse: Int) {
    var times = 0L
}

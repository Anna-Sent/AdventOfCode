package advent2021

import kotlin.math.max

private var result = 0

fun main() {

    result = test(
        """
            [[[0,[5,8]],[[1,7],[9,6]]],[[4,[1,2]],[[1,4],2]]]
            [[[5,[2,8]],4],[5,[[9,9],0]]]
            [6,[[[6,2],[5,6]],[[7,6],[4,7]]]]
            [[[6,[0,7]],[0,9]],[4,[9,[9,0]]]]
            [[[7,[6,4]],[3,[1,3]]],[[[5,5],1],9]]
            [[6,[[7,3],[3,2]]],[[[3,8],[5,7]],4]]
            [[[[5,4],[7,7]],8],[[8,3],8]]
            [[9,3],[[9,9],[6,[4,9]]]]
            [[2,[[7,7],7]],[[5,8],[[9,3],[0,2]]]]
            [[[[5,2],5],[8,[3,7]]],[[5,[7,5]],[4,4]]]
    """.trimIndent(), false
    )
    check(3993, result)

    result = test(
        """
            [[[1,4],[1,6]],[0,[5,[6,3]]]]
            [[[8,2],5],[[[9,8],[3,5]],[2,1]]]
            [[[[6,2],[0,6]],[[9,8],[7,8]]],[[6,3],[[8,8],3]]]
            [[[1,[2,1]],[5,7]],[[[3,1],[3,1]],[[8,4],[8,5]]]]
            [[[[6,4],7],[[1,6],5]],[7,[9,5]]]
            [[7,[[5,3],[0,9]]],[[[6,2],[6,8]],[5,[5,7]]]]
            [9,5]
            [[[[7,8],[8,0]],[[3,8],[0,7]]],[[1,[1,2]],2]]
            [[[4,[5,5]],[[6,8],[4,3]]],[[9,9],[4,[3,6]]]]
            [[[[2,8],7],[[6,1],[1,0]]],[[6,2],9]]
            [[[8,1],3],[9,[[1,4],[4,1]]]]
            [[[[0,1],[3,9]],[[4,3],6]],[[[4,8],8],[[8,3],[9,5]]]]
            [[[[7,3],7],[[5,9],0]],7]
            [[[5,[1,6]],3],[[3,5],9]]
            [[[[2,5],[1,8]],[[6,5],[0,1]]],[[[4,1],1],[0,[9,6]]]]
            [[[4,8],[[3,6],[3,8]]],[[[2,3],3],[[9,8],[7,9]]]]
            [[[[5,6],0],[9,[4,4]]],[[[3,1],[3,6]],[[6,0],3]]]
            [[[[4,3],4],4],[[[1,6],7],[8,[6,0]]]]
            [[[0,2],1],5]
            [[[[7,2],[9,0]],[8,[0,1]]],2]
            [[[1,6],[[6,2],5]],[[1,[8,2]],[[9,8],7]]]
            [[[8,1],9],[[[4,3],2],[[2,9],6]]]
            [[[[9,4],0],[4,0]],4]
            [[[5,[2,8]],[[5,3],[6,4]]],[8,3]]
            [[0,5],[[[3,4],7],[[0,2],[9,1]]]]
            [[[8,[7,9]],[[1,8],6]],[[4,[6,0]],0]]
            [[[1,0],[[6,7],4]],[[[2,5],[9,7]],[[7,8],0]]]
            [[9,[[7,1],3]],[[[9,2],[4,3]],[2,[1,8]]]]
            [[[5,[9,6]],4],[1,[[9,2],[6,8]]]]
            [6,[[[6,1],7],6]]
            [[4,[[5,6],9]],[[9,[6,6]],[[6,1],[8,2]]]]
            [[1,[9,5]],[[[5,8],9],5]]
            [[[[6,6],[1,8]],6],[[[4,9],4],[8,[9,8]]]]
            [[[[6,5],[4,4]],[[0,2],8]],[[[0,6],[4,5]],3]]
            [[[1,[6,9]],[9,[5,8]]],[5,2]]
            [[2,[[2,8],[3,3]]],[[[1,9],9],6]]
            [[3,2],[9,[2,2]]]
            [4,[3,[6,[2,0]]]]
            [[[[1,0],4],3],[[0,9],[[9,8],[7,1]]]]
            [[[2,6],[3,8]],[[5,5],[2,3]]]
            [6,[[[8,8],4],[[8,1],[6,6]]]]
            [[[5,9],[5,3]],7]
            [[[5,[1,2]],[6,[7,2]]],[[[0,5],3],3]]
            [[8,[[7,3],[9,7]]],[[2,[3,9]],[[1,7],[5,7]]]]
            [8,[4,6]]
            [[[4,4],[[4,5],[2,5]]],[[[9,1],0],[[2,9],1]]]
            [[[2,[2,8]],9],[5,[6,9]]]
            [[[[4,1],5],[6,[2,7]]],[1,2]]
            [[[6,[3,5]],0],[[0,3],4]]
            [[[[3,2],[8,0]],[5,1]],[[[9,7],3],[[6,5],[2,6]]]]
            [[1,[0,[1,4]]],[[[8,6],[6,9]],[[4,9],8]]]
            [[[[5,2],[4,3]],[0,[3,5]]],[0,[1,7]]]
            [[[8,1],[3,[8,1]]],[[[7,9],[6,2]],[[0,8],2]]]
            [[[2,[9,7]],[[6,6],[2,7]]],[[8,[6,4]],0]]
            [[3,0],[[6,3],1]]
            [[[[5,5],2],[9,7]],[[0,[3,5]],7]]
            [[[[4,8],2],0],[[4,[7,9]],[6,6]]]
            [[[1,0],[[9,4],[8,8]]],2]
            [[[6,1],9],[5,2]]
            [[[7,[0,3]],[[5,5],7]],[5,[[0,5],[5,3]]]]
            [[[[8,0],4],[[5,5],[9,4]]],[[[9,0],[2,5]],[6,[8,1]]]]
            [[[7,8],[0,[5,4]]],[[[7,6],[0,9]],[7,2]]]
            [[[4,[0,2]],[3,[4,9]]],[[[4,7],8],3]]
            [[1,[5,[7,3]]],8]
            [[[[1,3],[6,8]],3],[[6,1],8]]
            [[[[7,9],5],[[6,2],4]],[[5,[6,9]],1]]
            [[2,[3,[9,3]]],[[6,[2,7]],[4,8]]]
            [7,[[6,2],[[6,7],[5,0]]]]
            [[[9,[8,6]],1],[[4,8],[[6,1],[0,1]]]]
            [[[[4,6],[4,0]],[[2,4],0]],[[[0,5],[9,8]],[[3,4],[2,5]]]]
            [9,[3,[[5,5],[3,1]]]]
            [[[5,[7,1]],3],[[[8,2],5],[[2,8],[0,0]]]]
            [[[[8,3],0],[[5,0],5]],[[3,[8,2]],[[8,2],3]]]
            [[4,[[9,4],5]],[[[1,6],[0,2]],[0,8]]]
            [[[0,0],[[1,8],2]],[[[1,8],1],[0,[0,8]]]]
            [[[6,[1,5]],5],[[2,[0,1]],9]]
            [[7,[2,[2,8]]],[4,[[1,1],5]]]
            [1,[[4,[0,5]],4]]
            [[3,[[3,1],[1,2]]],[[[5,3],8],[5,2]]]
            [[[3,[2,0]],6],[[9,3],[[3,0],[1,6]]]]
            [4,[[6,[5,9]],[[4,1],[6,6]]]]
            [8,[3,0]]
            [[[[5,3],[8,8]],[[5,1],4]],[[6,6],[8,2]]]
            [[1,[[7,1],5]],[[[2,3],7],[[7,6],0]]]
            [9,[[4,3],[[6,2],0]]]
            [[[[4,0],4],[1,7]],[[[3,8],8],[[9,1],1]]]
            [[[0,1],[9,9]],7]
            [[[[1,7],0],[1,5]],[1,[2,2]]]
            [[[[6,1],[3,3]],[6,[9,0]]],[[7,0],3]]
            [[[[6,1],[9,8]],[[2,2],2]],[8,[3,6]]]
            [[6,[5,0]],[7,[1,7]]]
            [[4,[[6,1],6]],[[2,5],7]]
            [8,[8,[[6,4],1]]]
            [[[[0,2],4],[[2,6],2]],0]
            [[2,[[6,1],9]],[[7,[0,5]],[5,[9,4]]]]
            [3,[[8,7],[[8,9],6]]]
            [[[[7,8],[1,1]],[[2,6],[3,7]]],4]
            [[[[6,1],1],5],5]
            [[9,[4,[6,6]]],[[5,1],[8,2]]]
            [[5,[[7,3],4]],9]
    """.trimIndent(), false
    )
    check(4775, result)
}

private sealed class Leaf2021182 {

    data class Regular(val value: Int) : Leaf2021182() {
        override fun toString(): String {
            return value.toString()
        }
    }

    data class Complex(val first: Leaf2021182, val second: Leaf2021182) : Leaf2021182() {
        override fun toString(): String {
            return "[$first,$second]"
        }
    }
}

private fun test(input: String, print: Boolean): Int {
    val numbers = input.split("\n").map { it.parse() }
    var maxMagnitude = 0
    for (i in numbers.indices) {
        for (j in numbers.indices) {
            if (i != j) maxMagnitude = max(numbers[i].add(numbers[j], print).magnitude(), maxMagnitude)
        }
    }
    return maxMagnitude
}

private fun Leaf2021182.magnitude(): Int = when (this) {
    is Leaf2021182.Complex -> 3 * first.magnitude() + 2 * second.magnitude()
    is Leaf2021182.Regular -> value
}

private fun Leaf2021182.add(other: Leaf2021182, print: Boolean): Leaf2021182 {
    var result: Leaf2021182 = Leaf2021182.Complex(this, other)

    if (print) {
        println("1)) $this")
        println("2)) $other")

        println("after add: $result")
    }

    var prev: Leaf2021182? = null
    while (prev != result) {
        prev = result
        result = result.explodeLoop(print)
        result = result.split(print)
    }

    return result.also {
        if (print) {
            println("result is $result")
            println()
        }
    }
}

private fun Leaf2021182.explodeLoop(print: Boolean): Leaf2021182 {
    var result = this
    var prev: Leaf2021182? = null
    while (prev != result) {
        prev = result
        result = result.explode(print)
    }
    return result
}

private fun Leaf2021182.explode(print: Boolean): Leaf2021182 {
    val list = toList().toMutableList()

    var exploded = false
    var i = 0
    var balance = 0
    while (i < list.size) {
        if (list[i] == -1) {
            ++balance
            if (balance > 4) {
                val first = list[i + 1]
                val second = list[i + 3]
                // replace i [, i+1 num, i+2 ',', i+3 num, i+4 ] with i 0
                list[i] = 0
                for (j in 1..4) list.removeAt(i + 1)
                var j = i - 1
                while (j >= 0 && list[j] < 0) --j
                if (j >= 0) list[j] += first
                j = i + 1
                while (j < list.size && list[j] < 0) ++j
                if (j < list.size) list[j] += second
                exploded = true
                break
            }
        }
        if (list[i] == -2) --balance
        ++i
    }

    val result = list.fromList()
    return result.also { if (exploded && print) println("after explode: $it") }
}

private fun Leaf2021182.split(print: Boolean): Leaf2021182 {
    val list = toList().toMutableList()

    var splitted = false
    var i = 0
    while (i < list.size) {
        val item = list[i]
        if (item >= 10) {
            // replace i num with i [, i+1 num, i+2 ',', i+3 num, i+4 ]
            list[i] = -1
            list.add(i + 1, item / 2)
            list.add(i + 2, -3)
            list.add(i + 3, item / 2 + (if (item % 2 == 0) 0 else 1))
            list.add(i + 4, -2)
            splitted = true
            break
        }
        ++i
    }

    val result = list.fromList()
    return result.also { if (splitted && print) println("after split: $it") }
}

private fun Leaf2021182.toList(): List<Int> {
    val s = toString()
    val list = mutableListOf<Int>()
    var i = 0
    while (i < s.length) {
        if (s[i] == '[') {
            list += -1
            ++i
        }
        if (s[i] == ']') {
            list += -2
            ++i
        }
        var num = ""
        while (i < s.length && s[i].isDigit()) {
            num += s[i]
            ++i
        }
        if (num.isNotEmpty()) list += num.toInt()
        if (i < s.length && s[i] == ',') {
            list += -3
            ++i
        }
    }
    return list
}

private fun List<Int>.fromList(): Leaf2021182 {
    var s = ""
    for (j in indices) {
        val item = this[j]
        when {
            item == -3 -> s += ','
            item == -2 -> s += ']'
            item == -1 -> s += '['
            item >= 0 -> s += item
        }
    }
    return s.parse()
}

private fun String.parse(): Leaf2021182 {
    when {
        this[0] == '[' -> {
            var s1 = ""
            var i = 1
            var balance = 0
            while (true) {
                if (this[i] == ',' && balance == 0) break
                if (this[i] == '[') ++balance
                if (this[i] == ']') --balance
                s1 += this[i]
                ++i
            }
            var s2 = ""
            ++i
            while (true) {
                if (this[i] == ']' && balance == 0) break
                if (this[i] == '[') ++balance
                if (this[i] == ']') --balance
                s2 += this[i]
                ++i
            }
            return Leaf2021182.Complex(s1.parse(), s2.parse())
        }
        this[0] in '0'..'9' -> {
            var j = 0
            var num = ""
            while (j < length && this[j].isDigit()) {
                num += this[j]
                ++j
            }
            return Leaf2021182.Regular(num.toInt())
        }
        else -> throw IllegalArgumentException()
    }
}

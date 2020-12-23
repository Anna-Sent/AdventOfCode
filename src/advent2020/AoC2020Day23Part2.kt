package advent2020

private fun test(input: String, count: Int, add: Int): Long {
    val numbers = input.map { it.toString().toInt() }.toMutableList()

    val min = numbers.min()!!
    var max = numbers.max()!!

    for (i in max + 1..add) {
        numbers.add(i)
    }

    max = add.coerceAtLeast(max)

    val rootNode = Node2(numbers[0], null)
    var currentNode = rootNode
    val nodes = mutableMapOf<Int, Node2>()
    nodes[rootNode.value] = rootNode
    for (i in 1 until numbers.size) {
        val node = Node2(numbers[i], null)
        nodes[node.value] = node
        currentNode.next = node
        currentNode = node
    }
    currentNode.next = rootNode

    currentNode = rootNode
    for (i in 1..count) {

//        println("move $i")
//        println("current: ${currentNode.value}")

        val pickedUpValues = listOf(currentNode.next!!, currentNode.next!!.next!!, currentNode.next!!.next!!.next!!)

//        println("pick up: ${pickedUpValues.map { it.value }.toList()}")

        var find = currentNode.value - 1
        if (find < min) {
            find = max
        }
        var destinationNode = nodes[find]!!
        while (pickedUpValues.contains(destinationNode)) {
            --find
            if (find < min) {
                find = max
            }
            destinationNode = nodes[find]!!
        }

//        println("destination: ${destinationNode.value}")
//        println()

        currentNode.next = currentNode.next!!.next!!.next!!.next

        val tmp = destinationNode.next
        destinationNode.next = pickedUpValues[0]
        pickedUpValues[2].next = tmp

        currentNode = currentNode.next!!
    }

    val node1 = nodes[1]!!
    return node1.next!!.value.toLong() * node1.next!!.next!!.value.toLong()
}

private class Node2(val value: Int, var next: Node2?)

fun main() {
    test()
}

private var result: Long = 0

private fun test() {
    result = test("389125467", 10, 0)
    check(18, result)

    result = test("389125467", 100, 0)
    check(42, result)

    result = test("389125467", 10_000_000, 1_000_000)
    check(149245887792, result)

    result = test("123487596", 10_000_000, 1_000_000)
    check(248009574232, result)
}

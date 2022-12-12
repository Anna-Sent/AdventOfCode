package advent2022

import utils.Point

private var result = 0

fun main() {
    result = test("""
        Sabqponm
        abcryxxl
        accszExk
        acctuvwj
        abdefghi
    """.trimIndent())
    check(29, result)

    result = test("""
        abcccccaaaccccaacaaccaaaaaaaaaaaaaaaaaaaaccccccccccccccccccccccccccccccccccaaaaaa
        abcccccaaaacccaaaaaccaaaaaaaaaaaaaaaaaaaaacccccccccccccccccccccccccccccccccccaaaa
        abcccccaaaaccaaaaaccccaaaccaaaaaacccacaaaaccccccccccccccccaaaccccccccccccccccaaaa
        abcccccaaacccaaaaaaccccccccaaaaaacccccaaccccccccccccccccccaaaccccccccccccccccaaaa
        abcccccccccccccaaaacccccccaaaaaaaaccccccccccccccccccccccccaaacccccccccccccccaaaaa
        abccccccaacccccaacccccccccaaaaaaaaccccccccccccccccccccccccaaaaccaaacccccccccccccc
        abccccccaacccccccccccccccaaacccaaaacccaacaaccccccccccacaccaaacaajaacccccccccccccc
        abcccaaaaaaaaccccacccccccaaaccccaaacccaaaaaccccccccccaaaaaaajjjjkkkccccccaacccccc
        abcccaaaaaaaacaaaacccccccccccccccccccaaaaaccccccccciiiijjjjjjjjjkkkkcaaaaaacccccc
        abcccccaaaacccaaaaaacccccccccccccccccaaaaaacccccciiiiiijjjjjjjrrrkkkkaaaaaaaacccc
        abcccccaaaaacccaaaacccccccccaacccccccccaaaaccccciiiiiiiijjjjrrrrrsskkaaaaaaaacccc
        abccccaaaaaaccaaaaacccccccccaaaacccccccaccccccciiiiqqqqrrrrrrrrrssskkkaaaaaaacccc
        abaaccaaccaaccaacaacccccccaaaaaaccccccccccccccciiiqqqqqrrrrrrruussskkkaaaaacccccc
        abaaaacccccccccccccccccccccaaaaccccccccaaaccccciiqqqqqttrrrruuuuussskkaaaaacccccc
        abaaaacccccccccccccccccccccaaaaaccccccccaaaaccchiqqqtttttuuuuuuuussskkcccaacccccc
        abaaacccccaaaccacccccccccccaacaaccccccaaaaaaccchhqqqtttttuuuuxxuussslllcccccccccc
        abaaaaccccaaaaaacaaccccccaccccccccccccaaaaacccchhqqqttxxxxuuxxyyusssllllccccccccc
        abacaaccccaaaaaacaaaaaaaaaaccccccccccccaaaaaccchhqqqttxxxxxxxxyuusssslllccccccccc
        abcccccccaaaaaaacaaaaaaaaaccccaacccccccaaccaccchhhqqtttxxxxxxyyvvvsssslllcccccccc
        abcccccccaaaaaaaaaaaaaaaaaccccaaaaccccccccccccchhhppqttxxxxxyyyvvvvsqqqlllccccccc
        SbcccaaccaaaaaaaaaaaaaaaaaacaaaaaacccccccccccchhhhpptttxxxEzzyyyyvvvqqqqlllcccccc
        abcccaaccccaaacaaaaaaaaaaaaacaaaaccccccccccccchhhppptttxxxyyyyyyyyvvvqqqlllcccccc
        abaaaaaaaacaaacaaaaaaaaaaaaacaaaaacaaccccccccchhpppsssxxyyyyyyyyvvvvvqqqlllcccccc
        abaaaaaaaaccccccccaaacaaaccccaacaaaaaccccccaagggpppsswwwwwwyyyvvvvvvqqqmmmmcccccc
        abccaaaaccccaacaacaaacaaacccccccccaaacaaaccaagggppssswwwwwwyyywvvqqqqqqmmmccccccc
        abcaaaaaccccaaaaacaaccaaccaaaccaaaaaaaaaaaaaagggppsssswwwswwyywvrqqqqmmmmcccccccc
        abcaaaaaaccaaaaacccccccccaaaaccaaaaaaaaaacaaagggpppssssssswwwwwwrrqmmmmmccccccccc
        abcaacaaaccaaaaaaccccccccaaaaccccaaaaaacccaaagggppppssssssrwwwwrrrmmmmmdccccccccc
        abccccaaaccaaaaaaccccccccaaaaccccaaaaaacccaacggggpooooooosrrwwwrrnmmmddddcacccccc
        abccccaaaaaaaacccccccccccccccccccaaaaaaaccccccggggoooooooorrrrrrrnnmdddddaaaacccc
        abcccccaaaaaaccccccccccccccccccccaaacaaacccccccggggfffooooorrrrrrnnddddaaaaaacccc
        abccaaaaaaaacccccccccccccccccccccaccccccccccccccggffffffooonrrrrnnndddaaaaaaacccc
        abccaaaaaaaaaccccaacccccccccccccccccccccccccccccccfffffffoonnnnnnndddcaaaaacccccc
        abccaaaaaaaaaacccaaccccccccccccccaccccccccccccccccccccffffnnnnnnnedddaaaaaacccccc
        abcccccaaaaaaaaaaaacccccccaccccaaacccccccccccccccccccccfffeennnneeedcccccaacccccc
        abcccccaaacccaaaaaaaaccccaaacccaaaccacccccccccccccccccccafeeeeeeeeecccccccccccccc
        abcccccaaccccaaaaaaaaacccaaaaaaaaaaaaccccccaaaccccccccccaaeeeeeeeeeccccccccccccca
        abaccccccccccaaaaaaaaacccaaaaaaaaaaacccccccaaaaacccccccaaaaceeeeecccccccccccaccca
        abaccccccccccaaaaaaaaccaaaaaaaaaaaaaacccccaaaaaccccccccaaaccccaaacccccccccccaaaaa
        abaccccccccccaaaaaaacccaaaaaaaaaaaaaacccccaaaaacccccccccccccccccccccccccccccaaaaa
        abaccccccccccaccaaaacccaaaaaaaaaaaaaaccccccaaaaaccccccccccccccccccccccccccccaaaaa
    """.trimIndent())
    check(349, result)
}

private fun test(input: String): Int {
    val starts = mutableListOf<Point>()
    var end: Point? = null
    val map = mutableListOf<String>()
    for ((index, line) in input.split("\n").withIndex()) {
        var newLine = line
        if ('S' in line) {
            val start = Point(index, line.indexOf('S'))
            newLine = newLine.replace('S', 'a')
            starts += start
        }
        if ('E' in line) {
            end = Point(index, line.indexOf('E'))
            newLine = newLine.replace('E', 'z')
        }
        if ('a' in line) {
            for (i in line.indices) {
                if (line[i] == 'a') {
                    val start = Point(index, i)
                    starts += start
                }
            }
        }
        map += newLine
    }
    return starts.map { start -> bfs(start, end!!, map) }.filter { it != -1 }.min()!!
}

private fun bfs(start: Point, end: Point, map: List<String>): Int {
    val closed = mutableSetOf<Point>()
    var opened = mutableSetOf<Point>()

    opened += start
    var steps = 0

    while (opened.size > 0) {
        val achievable = mutableSetOf<Point>()
        for (current in opened) {
            if (current == end) {
                return steps
            }
            val set = generateNext(current, map)
            for (next in set) {
                if (next !in closed) {
                    achievable += next
                }
            }
            closed += current
        }
        opened = achievable
        ++steps
    }

    return -1
}

private fun generateNext(currentPoint: Point, map: List<String>): Set<Point> {
    val currentValue = map[currentPoint.x][currentPoint.y]
    val set = mutableSetOf<Point>()

    fun checkNext(nextPoint: Point) {
        val nextValue = map[nextPoint.x][nextPoint.y]
        if (nextValue - currentValue <= 1) {
            set += nextPoint
        }
    }

    val up = Point(currentPoint.x - 1, currentPoint.y)
    if (up.x >= 0) checkNext(up)
    val down = Point(currentPoint.x + 1, currentPoint.y)
    if (down.x < map.size) checkNext(down)
    val left = Point(currentPoint.x, currentPoint.y - 1)
    if (left.y >= 0) checkNext(left)
    val right = Point(currentPoint.x, currentPoint.y + 1)
    if (right.y < map[currentPoint.x].length) checkNext(right)
    return set
}

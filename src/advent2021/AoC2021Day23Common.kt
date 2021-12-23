package advent2021

import utils.Point
import java.util.*

fun State.findPath(endStateConfiguration: String): State? {
    val closed = mutableSetOf<State>()
    val opened = PriorityQueue<State> { a, b -> a.energy.compareTo(b.energy) }

    opened.add(this)

    while (opened.size > 0) {
        val currentState = opened.poll()
        if (closed.contains(currentState)) {
            continue
        }
        if (currentState.s == endStateConfiguration) {
            return currentState
        }
        val next = currentState.nextPossible()
        for (nextState in next) {
            opened.add(nextState)
        }
        closed.add(currentState)
    }

    return null
}

private val amphipods = arrayOf('A', 'B', 'C', 'D')
private val energies = arrayOf(1, 10, 100, 1000)

private fun State.nextPossible(): List<State> {
    val result = mutableListOf<State>()
    for (amphipod in amphipods) {
        val amphipodPositions = findPositions(amphipod)
        for (position in amphipodPositions) {
            println("from for $amphipod $position")
            println(s)
            val next = generateNext(position)
            for ((index, pair) in next.withIndex()) {
                val (nextPoint, energy) = pair
                val newState = transform(amphipod, position, nextPoint, energy)
                result += newState
                println("to ${index + 1} from ${next.size}")
                println(newState.s)
                println()
            }
        }
    }
    println()
    println()
    return result
}

private fun State.transform(who: Char, from: Point, to: Point, energy: Int): State {
    var newString = ""
    for (i in lines.indices) {
        for (j in lines[i].indices) {
            val p = Point(i, j)
            newString += when (p) {
                from -> '.'
                to -> who
                else -> lines[i][j]
            }
        }
        if (i < lines.lastIndex) newString += "\n"
    }
    return State(newString, this.energy + energy)
}

private fun State.generateNext(p: Point): List<Pair<Point, Int>> {
    val i = p.x
    val j = p.y

    val items = mutableListOf<Pair<Point, Int>>()

    val amphipod = get(i, j)

    items += generateNext(
        i, j, amphipod, when (amphipod) {
            'A' -> 3
            'B' -> 5
            'C' -> 7
            'D' -> 9
            else -> throw IllegalArgumentException("invalid amphipod")
        }
    )

    return items
}

private fun State.generateNext(i: Int, j: Int, amphipod: Char, amphipodBurrow: Int): List<Pair<Point, Int>> {
    val items = mutableListOf<Pair<Point, Int>>()
    if (i > 1) {
        if (j == amphipodBurrow) {
            // we are in the right burrow
            if (!isBurrowValid(amphipod, j)) {
                // we can go out AND stand not above burrows
                var canContinueMoving = true
                var steps = 0
                for (k in i - 1 downTo 1) {
                    if (get(k, j) != '.') {
                        canContinueMoving = false
                        break
                    } else {
                        ++steps
                    }
                }
                val initSteps = steps
                if (canContinueMoving) {
                    var l = j + 1
                    steps = initSteps
                    while (get(1, l) == '.') {
                        ++steps
                        if (get(2, l) == '#') {
                            items += Point(1, l) to steps * energies[amphipod - 'A']
                        }
                        ++l
                    }
                    l = j - 1
                    steps = initSteps
                    while (get(1, l) == '.') {
                        ++steps
                        if (get(2, l) == '#') {
                            items += Point(1, l) to steps * energies[amphipod - 'A']
                        }
                        --l
                    }
                }
            }
        } else {
            // we are in the foreign burrow
            // we can go out AND (stand not above burrows OR go into native burrow)
            var canContinueMoving = true
            var steps = 0
            for (k in i - 1 downTo 1) {
                if (get(k, j) != '.') {
                    canContinueMoving = false
                    break
                } else {
                    ++steps
                }
            }
            val initSteps = steps
            if (canContinueMoving) {
                var l = j + 1
                steps = initSteps
                while (get(1, l) == '.') {
                    ++steps
                    if (get(2, l) == '#') {
                        items += Point(1, l) to steps * energies[amphipod - 'A']
                    }
                    if (l == amphipodBurrow && isBurrowValid(amphipod, l)) {
                        var r = 2
                        while (get(r, l) == '.') {
                            ++steps
                            ++r
                            if (get(r, l) != '.') {
                                items += Point(r - 1, l) to steps * energies[amphipod - 'A']
                            }
                        }
                    }
                    ++l
                }
                l = j - 1
                steps = initSteps
                while (get(1, l) == '.') {
                    ++steps
                    if (get(2, l) == '#') {
                        items += Point(1, l) to steps * energies[amphipod - 'A']
                    }
                    if (l == amphipodBurrow && isBurrowValid(amphipod, l)) {
                        var r = 2
                        while (get(r, l) == '.') {
                            ++steps
                            ++r
                            if (get(r, l) != '.') {
                                items += Point(r - 1, l) to steps * energies[amphipod - 'A']
                            }
                        }
                    }
                    --l
                }
            }
        }
    } else {
        // we are out of burrow
        // we can go into native burrow
        var l = j + 1
        var steps = 0
        while (get(1, l) == '.') {
            ++steps
            if (l == amphipodBurrow && isBurrowValid(amphipod, l)) {
                var r = 2
                while (get(r, l) == '.') {
                    ++steps
                    ++r
                    if (get(r, l) != '.') {
                        items += Point(r - 1, l) to steps * energies[amphipod - 'A']
                    }
                }
            }
            ++l
        }
        l = j - 1
        steps = 0
        while (get(1, l) == '.') {
            ++steps
            if (l == amphipodBurrow && isBurrowValid(amphipod, l)) {
                var r = 2
                while (get(r, l) == '.') {
                    ++steps
                    ++r
                    if (get(r, l) != '.') {
                        items += Point(r - 1, l) to steps * energies[amphipod - 'A']
                    }
                }
            }
            --l
        }
    }
    return items
}

private fun State.isBurrowValid(amphipod: Char, j: Int): Boolean {
    var valid = true
    for (i in 2..lines.lastIndex - 1) {
        if (lines[i][j] != amphipod && lines[i][j] != '.') valid = false
    }
    return valid
}

private fun State.get(i: Int, j: Int) = lines[i][j]

private fun State.findPositions(amphipod: Char): List<Point> {
    val result = mutableListOf<Point>()
    for (i in lines.indices) {
        for (j in lines[i].indices) {
            if (lines[i][j] == amphipod) result += Point(i, j)
        }
    }
    return result
}

class State(val s: String, val energy: Int) {

    val lines = s.split("\n")

    override fun toString(): String {
        return "energy $energy\n$s"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as State

        if (s != other.s) return false

        return true
    }

    override fun hashCode(): Int {
        return s.hashCode()
    }
}

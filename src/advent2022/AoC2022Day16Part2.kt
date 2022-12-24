package advent2022

import kotlin.math.max

private var result = 0

fun main() {
    result = test("""
        Valve AA has flow rate=0; tunnels lead to valves DD, II, BB
        Valve BB has flow rate=13; tunnels lead to valves CC, AA
        Valve CC has flow rate=2; tunnels lead to valves DD, BB
        Valve DD has flow rate=20; tunnels lead to valves CC, AA, EE
        Valve EE has flow rate=3; tunnels lead to valves FF, DD
        Valve FF has flow rate=0; tunnels lead to valves EE, GG
        Valve GG has flow rate=0; tunnels lead to valves FF, HH
        Valve HH has flow rate=22; tunnel leads to valve GG
        Valve II has flow rate=0; tunnels lead to valves AA, JJ
        Valve JJ has flow rate=21; tunnel leads to valve II
    """.trimIndent())
    check(1707, result)

    result = test("""
        Valve ED has flow rate=0; tunnels lead to valves PS, AW
        Valve SI has flow rate=0; tunnels lead to valves AA, HX
        Valve LX has flow rate=22; tunnels lead to valves DY, YH
        Valve CR has flow rate=0; tunnels lead to valves BE, HX
        Valve BI has flow rate=0; tunnels lead to valves GC, AY
        Valve PB has flow rate=4; tunnels lead to valves IX, YG, RI, KR, BV
        Valve YY has flow rate=0; tunnels lead to valves PH, GJ
        Valve PH has flow rate=11; tunnels lead to valves YY, VE, ZG, MM
        Valve DY has flow rate=0; tunnels lead to valves LX, AW
        Valve SD has flow rate=0; tunnels lead to valves AY, EC
        Valve SV has flow rate=24; tunnels lead to valves CC, GF
        Valve RL has flow rate=0; tunnels lead to valves OW, IN
        Valve GF has flow rate=0; tunnels lead to valves RQ, SV
        Valve BE has flow rate=5; tunnels lead to valves CR, JC, MF, IT
        Valve PR has flow rate=0; tunnels lead to valves BV, GJ
        Valve AW has flow rate=21; tunnels lead to valves VE, DY, TR, ED
        Valve FY has flow rate=17; tunnels lead to valves GG, KJ
        Valve GC has flow rate=0; tunnels lead to valves BI, GJ
        Valve RI has flow rate=0; tunnels lead to valves PB, AY
        Valve RQ has flow rate=0; tunnels lead to valves HH, GF
        Valve IT has flow rate=0; tunnels lead to valves MZ, BE
        Valve XG has flow rate=0; tunnels lead to valves BL, AA
        Valve MK has flow rate=0; tunnels lead to valves HX, DV
        Valve IX has flow rate=0; tunnels lead to valves PB, JC
        Valve BV has flow rate=0; tunnels lead to valves PR, PB
        Valve TR has flow rate=0; tunnels lead to valves CD, AW
        Valve PS has flow rate=0; tunnels lead to valves ED, AY
        Valve HH has flow rate=12; tunnels lead to valves RQ, NL, ZQ
        Valve AA has flow rate=0; tunnels lead to valves KR, SI, XG, EC, ZG
        Valve FT has flow rate=0; tunnels lead to valves IN, YH
        Valve YG has flow rate=0; tunnels lead to valves PB, HX
        Valve HX has flow rate=14; tunnels lead to valves MK, ZQ, YG, SI, CR
        Valve DV has flow rate=0; tunnels lead to valves MK, QR
        Valve GJ has flow rate=3; tunnels lead to valves PR, CD, YY, GC, BL
        Valve BL has flow rate=0; tunnels lead to valves GJ, XG
        Valve CD has flow rate=0; tunnels lead to valves TR, GJ
        Valve GG has flow rate=0; tunnels lead to valves FY, NL
        Valve JC has flow rate=0; tunnels lead to valves IX, BE
        Valve JN has flow rate=0; tunnels lead to valves OW, QR
        Valve RM has flow rate=18; tunnel leads to valve KJ
        Valve NL has flow rate=0; tunnels lead to valves GG, HH
        Valve QR has flow rate=20; tunnels lead to valves CC, DV, PN, JN
        Valve ZG has flow rate=0; tunnels lead to valves AA, PH
        Valve AY has flow rate=6; tunnels lead to valves RI, PS, SD, BI, MM
        Valve VE has flow rate=0; tunnels lead to valves PH, AW
        Valve OW has flow rate=25; tunnels lead to valves MZ, RL, JN
        Valve MM has flow rate=0; tunnels lead to valves AY, PH
        Valve KJ has flow rate=0; tunnels lead to valves RM, FY
        Valve MF has flow rate=0; tunnels lead to valves BE, PN
        Valve YH has flow rate=0; tunnels lead to valves LX, FT
        Valve ZQ has flow rate=0; tunnels lead to valves HX, HH
        Valve KR has flow rate=0; tunnels lead to valves AA, PB
        Valve PN has flow rate=0; tunnels lead to valves MF, QR
        Valve CC has flow rate=0; tunnels lead to valves SV, QR
        Valve MZ has flow rate=0; tunnels lead to valves OW, IT
        Valve EC has flow rate=0; tunnels lead to valves SD, AA
        Valve IN has flow rate=16; tunnels lead to valves RL, FT
    """.trimIndent())
    check(0, result)
}

private fun test(input: String): Int {
    val regEx = """Valve ([A-Z]{2}) has flow rate=(\d+); tunnels? leads? to valves? (.+)""".toRegex()
    val valvesMap = mutableMapOf<String, Valve162>()
    for (line in input.split("\n")) {
        val result = regEx.find(line)
        val (name, flowRateStr, namesStr) = result!!.destructured
        val names = namesStr.split(", ")
        val valve = Valve162(flowRateStr.toInt(), names)
        valvesMap[name] = valve
    }

    val shouldOpenValveSize = valvesMap.values.count { it.flowRate > 0 }
    val initialState = State162(emptyList(), Action162.Staying("AA"), Action162.Staying("AA"), 0)

    fun State162.generateNext1(): Set<State162> {
        val next = mutableSetOf<State162>()
        when (action1) {
            is Action162.Moving -> {
                if (action1.valve !in openedValves && valvesMap[action1.valve]!!.flowRate > 0) {
                    next += State162(openedValves, Action162.Opening(action1.valve), action2, totalPressure)
                }
                val canMoveTo = valvesMap[action1.valve]!!.names
                for (nextValveName in canMoveTo) {
                    next += State162(openedValves, Action162.Moving(nextValveName), action2, totalPressure)
                }
            }

            is Action162.Opening -> {
                val newOpenedValves = arrayListOf<String>()
                newOpenedValves += openedValves
                newOpenedValves += action1.valve
                if (newOpenedValves.size >= shouldOpenValveSize) {
                    next += State162(newOpenedValves, Action162.Staying(action1.valve), action2, totalPressure)
                } else {
                    val canMoveTo = valvesMap[action1.valve]!!.names
                    for (nextValveName in canMoveTo) {
                        next += State162(newOpenedValves, Action162.Moving(nextValveName), action2, totalPressure)
                    }
                }
            }

            is Action162.Staying -> {}
        }
        return next
    }

    fun State162.generateNext2(): Set<State162> {
        val next = mutableSetOf<State162>()
        when (action2) {
            is Action162.Moving -> {
                if (action2.valve !in openedValves && valvesMap[action2.valve]!!.flowRate > 0) {
                    next += State162(openedValves, action1, Action162.Opening(action2.valve), totalPressure)
                }
                val canMoveTo = valvesMap[action2.valve]!!.names
                for (nextValveName in canMoveTo) {
                    next += State162(openedValves, action1, Action162.Moving(nextValveName), totalPressure)
                }
            }

            is Action162.Opening -> {
                val newOpenedValves = arrayListOf<String>()
                newOpenedValves += openedValves
                newOpenedValves += action2.valve
                if (newOpenedValves.size >= shouldOpenValveSize) {
                    next += State162(newOpenedValves, action1, Action162.Staying(action2.valve), totalPressure)
                } else {
                    val canMoveTo = valvesMap[action2.valve]!!.names
                    for (nextValveName in canMoveTo) {
                        next += State162(newOpenedValves, action1, Action162.Moving(nextValveName), totalPressure)
                    }
                }
            }

            is Action162.Staying -> {}
        }
        return next
    }

    fun State162.generateNext(): Set<State162> {
        val next = mutableSetOf<State162>()

        if (this == initialState) {
            val canMoveTo = valvesMap["AA"]!!.names
            for (i in 0..canMoveTo.lastIndex - 1) {
                for (j in i + 1..canMoveTo.lastIndex) {
                    next += State162(emptyList(), Action162.Moving(canMoveTo[i]), Action162.Moving(canMoveTo[j]), 0)
                }
            }
            return next
        }

        if (openedValves.size >= shouldOpenValveSize) {
            return next
        }

        val next1 = generateNext1()
        val next2 = generateNext2()

        val pairs = mutableSetOf<Pair<Action162, Action162>>()

        for (nextState1 in next1) {
            for (nextState2 in next2) {
                val newOpenedValves = mutableSetOf<String>()
                newOpenedValves += nextState1.openedValves
                newOpenedValves += nextState2.openedValves
                val pressure = totalPressure + newOpenedValves.map { valvesMap[it]!!.flowRate }.sum()
                if (nextState1.action1 is Action162.Staying || nextState2.action2 is Action162.Staying) {
                    next += State162(newOpenedValves.toList(), Action162.Staying(action1.valve()), Action162.Staying(action2.valve()), pressure)
                } else if (nextState1.action1 != nextState2.action2) {
                    if (nextState1.action1 to nextState2.action2 !in pairs) {
                        if (nextState1.action1.valve() != nextState2.action2.valve()) {
                            next += State162(newOpenedValves.toList(), nextState1.action1, nextState2.action2, pressure)
                        }
                        pairs += nextState1.action1 to nextState2.action2
                        pairs += nextState2.action2 to nextState1.action1
                    }
                }
            }
        }

        return next
    }

    fun bfs(start: State162): Set<Pair<Int, State162>> {
        val results = mutableSetOf<Pair<Int, State162>>()

        val closed = mutableSetOf<State162>()
        var opened = mutableSetOf<State162>()

        opened += start
        var steps = 0

        while (opened.size > 0) {
            for (current in opened) {
                if (current.openedValves.size >= shouldOpenValveSize) {
                    results += steps to current
                }
            }
            if (steps == 26) {
                break
            }
            val achievable = mutableSetOf<State162>()
            for (current in opened) {
                val set = current.generateNext()
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

        return results
    }

    val set = bfs(initialState)
    println("received ${set.size} results")
    var value = 0
    for (result in set) {
        val (minute, state) = result
        val pressure = state.totalPressure + (26 - minute) * state.openedValves.map { valvesMap[it]!!.flowRate }.sum()
        value = max(pressure, value)
    }
    return value
}

private data class State162(val openedValves: List<String>, val action1: Action162, val action2: Action162, val totalPressure: Int)

private sealed class Action162 {
    abstract fun valve(): String
    data class Moving(val valve: String) : Action162() {
        override fun valve() = valve
    }

    data class Opening(val valve: String) : Action162() {
        override fun valve() = valve
    }

    data class Staying(val valve: String) : Action162() {
        override fun valve() = valve
    }
}

private class Valve162(val flowRate: Int, val names: List<String>)

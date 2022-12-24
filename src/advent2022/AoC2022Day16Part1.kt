package advent2022

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
    check(1651, result)

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
    check(2359, result)
}

private fun test(input: String): Int {
    val regEx = """Valve ([A-Z]{2}) has flow rate=(\d+); tunnels? leads? to valves? (.+)""".toRegex()
    val valvesMap = mutableMapOf<String, Valve161>()
    for (line in input.split("\n")) {
        val result = regEx.find(line)
        val (name, flowRateStr, namesStr) = result!!.destructured
        val names = namesStr.split(", ")
        val valve = Valve161(flowRateStr.toInt(), names)
        valvesMap[name] = valve
    }

    val shouldOpenValveSize = valvesMap.values.count { it.flowRate > 0 }

    fun State161.generateNext(): Set<State161> {
        val next = mutableSetOf<State161>()

        if (openedValves.size >= shouldOpenValveSize) {
            val pressure = totalPressure + openedValves.map { valvesMap[it]!!.flowRate }.sum()
            next += State161(openedValves, Action161.Staying(action.valve()), pressure)
        } else {

            when (action) {
                is Action161.Moving -> {
                    val pressure = totalPressure + openedValves.map { valvesMap[it]!!.flowRate }.sum()
                    if (action.valve !in openedValves && valvesMap[action.valve]!!.flowRate > 0) {
                        next += State161(openedValves, Action161.Opening(action.valve), pressure)
                    }
                    val canMoveTo = valvesMap[action.valve]!!.names
                    for (nextValveName in canMoveTo) {
                        next += State161(openedValves, Action161.Moving(nextValveName), pressure)
                    }
                }

                is Action161.Opening -> {
                    val newOpenedValves = arrayListOf<String>()
                    newOpenedValves += openedValves
                    newOpenedValves += action.valve
                    val pressure = totalPressure + newOpenedValves.map { valvesMap[it]!!.flowRate }.sum()
                    if (newOpenedValves.size >= shouldOpenValveSize) {
                        next += State161(newOpenedValves, Action161.Staying(action.valve), pressure)
                    } else {
                        val canMoveTo = valvesMap[action.valve]!!.names
                        for (nextValveName in canMoveTo) {
                            next += State161(newOpenedValves, Action161.Moving(nextValveName), pressure)
                        }
                    }
                }

                is Action161.Staying -> {
                    if (action.valve == "AA") {
                        val canMoveTo = valvesMap["AA"]!!.names
                        for (nextValveName in canMoveTo) {
                            next += State161(emptyList(), Action161.Moving(nextValveName), 0)
                        }
                    }
                }
            }

        }

        return next
    }

    fun bfs(start: State161): Set<State161> {
        val closed = mutableSetOf<State161>()
        var opened = mutableSetOf<State161>()

        opened += start
        var steps = 0

        while (opened.size > 0) {
            if (steps == 30) {
                return opened
            }
            val achievable = mutableSetOf<State161>()
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

        return emptySet()
    }

    return bfs(State161(emptyList(), Action161.Staying("AA"), 0)).maxBy { it.totalPressure }!!.totalPressure
}

private data class State161(val openedValves: List<String>, val action: Action161, val totalPressure: Int)

private sealed class Action161 {
    abstract fun valve(): String
    data class Moving(val valve: String) : Action161() {
        override fun valve() = valve
    }

    data class Opening(val valve: String) : Action161() {
        override fun valve() = valve
    }

    data class Staying(val valve: String) : Action161() {
        override fun valve() = valve
    }
}

private class Valve161(val flowRate: Int, val names: List<String>)

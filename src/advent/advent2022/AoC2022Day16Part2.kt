package advent.advent2022

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
    check(2999, result)
}

private fun test(input: String): Int {
    data class Valve(
            val flowRate: Int,
            val valves: List<String>
    )

    val regex = """Valve ([A-Z]{2}) has flow rate=(\d+); tunnels? leads? to valves? (.+)""".toRegex()
    val valves = mutableMapOf<String, Valve>()
    for (line in input.split("\n")) {
        val result = regex.find(line)
        val (name, flowRateStr, namesStr) = result!!.destructured
        val names = namesStr.split(", ")
        val valve = Valve(flowRateStr.toInt(), names)
        valves[name] = valve
    }

    data class State(
            val valve1: String = "AA",
            val valve2: String = "AA",
            val openedValves: List<String> = emptyList(),
            val pressure: Int = 0,
            val minutes: Int = 0
    ) {
        var prevState: State? = null
    }

    var maxPressureState: State? = null

    fun dfs(state: State) {
        if (state.minutes == 26) {
            if (state.pressure > (maxPressureState?.pressure ?: 0)) {
                maxPressureState = state
                println("max pressure is ${state.pressure} now")
            }
            return
        }
        val currentMinute = state.minutes
        if (currentMinute >= 1 && maxPressureState != null) {
            var s = maxPressureState
            while ((s?.minutes ?: 0) != currentMinute) {
                s = s?.prevState
            }
            if (s != null) {
                if (s.pressure - state.pressure > 9) return
            }
        }
        if (valves.filter { it.value.flowRate > 0 }.count { it.key !in state.openedValves } == 0) {
            dfs(State(
                    state.valve1,
                    state.valve2,
                    state.openedValves,
                    state.pressure + state.openedValves.map { valves[it]!!.flowRate }.sum(),
                    state.minutes + 1
            ).apply { prevState = state })
            return
        }
        val canOpen1 = state.valve1 !in state.openedValves && valves[state.valve1]!!.flowRate > 0
        val canOpen2 = state.valve2 !in state.openedValves && valves[state.valve2]!!.flowRate > 0
        if (canOpen1 && canOpen2 && state.valve1 != state.valve2) {
            dfs(State(
                    state.valve1,
                    state.valve2,
                    state.openedValves + state.valve1 + state.valve2,
                    state.pressure + state.openedValves.map { valves[it]!!.flowRate }.sum(),
                    state.minutes + 1
            ).apply { prevState = state })
        }
        if (canOpen1) {
            val whereToGo2 = valves[state.valve2]!!.valves
            for (valve2 in whereToGo2) {
                dfs(State(
                        state.valve1,
                        valve2,
                        state.openedValves + state.valve1,
                        state.pressure + state.openedValves.map { valves[it]!!.flowRate }.sum(),
                        state.minutes + 1
                ).apply { prevState = state })
            }
        }
        if (canOpen2) {
            val whereToGo1 = valves[state.valve1]!!.valves
            for (valve1 in whereToGo1) {
                dfs(State(
                        valve1,
                        state.valve2,
                        state.openedValves + state.valve2,
                        state.pressure + state.openedValves.map { valves[it]!!.flowRate }.sum(),
                        state.minutes + 1
                ).apply { prevState = state })
            }
        }
        val whereToGo1 = valves[state.valve1]!!.valves
        for (valve1 in whereToGo1) {
            val whereToGo2 = valves[state.valve2]!!.valves
            for (valve2 in whereToGo2) {
                dfs(State(
                        valve1,
                        valve2,
                        state.openedValves,
                        state.pressure + state.openedValves.map { valves[it]!!.flowRate }.sum(),
                        state.minutes + 1
                ).apply { prevState = state })
            }
        }
    }

    dfs(State())
    return maxPressureState!!.pressure
}

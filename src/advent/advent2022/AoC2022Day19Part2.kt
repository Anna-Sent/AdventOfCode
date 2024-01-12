package advent.advent2022

import kotlin.math.max
import kotlin.math.min

private var result = 0

fun main() {
    result = test("""
Blueprint 1: Each ore robot costs 4 ore. Each clay robot costs 2 ore. Each obsidian robot costs 3 ore and 14 clay. Each geode robot costs 2 ore and 7 obsidian.
Blueprint 2: Each ore robot costs 2 ore. Each clay robot costs 3 ore. Each obsidian robot costs 3 ore and 8 clay. Each geode robot costs 3 ore and 12 obsidian.
    """.trimIndent())
    check(56 * 62, result)

    result = test("""
Blueprint 1: Each ore robot costs 2 ore. Each clay robot costs 4 ore. Each obsidian robot costs 3 ore and 20 clay. Each geode robot costs 2 ore and 17 obsidian.
Blueprint 2: Each ore robot costs 4 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 11 clay. Each geode robot costs 4 ore and 12 obsidian.
Blueprint 3: Each ore robot costs 4 ore. Each clay robot costs 4 ore. Each obsidian robot costs 3 ore and 19 clay. Each geode robot costs 4 ore and 15 obsidian.
Blueprint 4: Each ore robot costs 4 ore. Each clay robot costs 4 ore. Each obsidian robot costs 3 ore and 20 clay. Each geode robot costs 2 ore and 10 obsidian.
Blueprint 5: Each ore robot costs 2 ore. Each clay robot costs 3 ore. Each obsidian robot costs 3 ore and 18 clay. Each geode robot costs 2 ore and 19 obsidian.
Blueprint 6: Each ore robot costs 2 ore. Each clay robot costs 3 ore. Each obsidian robot costs 3 ore and 11 clay. Each geode robot costs 2 ore and 16 obsidian.
Blueprint 7: Each ore robot costs 4 ore. Each clay robot costs 3 ore. Each obsidian robot costs 4 ore and 8 clay. Each geode robot costs 3 ore and 7 obsidian.
Blueprint 8: Each ore robot costs 3 ore. Each clay robot costs 3 ore. Each obsidian robot costs 3 ore and 17 clay. Each geode robot costs 2 ore and 13 obsidian.
Blueprint 9: Each ore robot costs 3 ore. Each clay robot costs 4 ore. Each obsidian robot costs 3 ore and 12 clay. Each geode robot costs 3 ore and 17 obsidian.
Blueprint 10: Each ore robot costs 3 ore. Each clay robot costs 3 ore. Each obsidian robot costs 2 ore and 15 clay. Each geode robot costs 3 ore and 9 obsidian.
Blueprint 11: Each ore robot costs 3 ore. Each clay robot costs 3 ore. Each obsidian robot costs 2 ore and 16 clay. Each geode robot costs 2 ore and 18 obsidian.
Blueprint 12: Each ore robot costs 3 ore. Each clay robot costs 3 ore. Each obsidian robot costs 3 ore and 15 clay. Each geode robot costs 2 ore and 8 obsidian.
Blueprint 13: Each ore robot costs 4 ore. Each clay robot costs 3 ore. Each obsidian robot costs 4 ore and 11 clay. Each geode robot costs 3 ore and 15 obsidian.
Blueprint 14: Each ore robot costs 3 ore. Each clay robot costs 3 ore. Each obsidian robot costs 3 ore and 9 clay. Each geode robot costs 3 ore and 7 obsidian.
Blueprint 15: Each ore robot costs 4 ore. Each clay robot costs 2 ore. Each obsidian robot costs 2 ore and 16 clay. Each geode robot costs 2 ore and 8 obsidian.
Blueprint 16: Each ore robot costs 3 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 16 clay. Each geode robot costs 3 ore and 15 obsidian.
Blueprint 17: Each ore robot costs 4 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 20 clay. Each geode robot costs 2 ore and 8 obsidian.
Blueprint 18: Each ore robot costs 2 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 13 clay. Each geode robot costs 3 ore and 11 obsidian.
Blueprint 19: Each ore robot costs 3 ore. Each clay robot costs 3 ore. Each obsidian robot costs 2 ore and 12 clay. Each geode robot costs 2 ore and 10 obsidian.
Blueprint 20: Each ore robot costs 3 ore. Each clay robot costs 3 ore. Each obsidian robot costs 3 ore and 19 clay. Each geode robot costs 3 ore and 19 obsidian.
Blueprint 21: Each ore robot costs 4 ore. Each clay robot costs 3 ore. Each obsidian robot costs 2 ore and 19 clay. Each geode robot costs 3 ore and 10 obsidian.
Blueprint 22: Each ore robot costs 2 ore. Each clay robot costs 3 ore. Each obsidian robot costs 3 ore and 16 clay. Each geode robot costs 2 ore and 11 obsidian.
Blueprint 23: Each ore robot costs 4 ore. Each clay robot costs 3 ore. Each obsidian robot costs 3 ore and 10 clay. Each geode robot costs 3 ore and 10 obsidian.
Blueprint 24: Each ore robot costs 3 ore. Each clay robot costs 4 ore. Each obsidian robot costs 3 ore and 15 clay. Each geode robot costs 4 ore and 16 obsidian.
Blueprint 25: Each ore robot costs 4 ore. Each clay robot costs 3 ore. Each obsidian robot costs 2 ore and 5 clay. Each geode robot costs 2 ore and 10 obsidian.
Blueprint 26: Each ore robot costs 3 ore. Each clay robot costs 4 ore. Each obsidian robot costs 3 ore and 18 clay. Each geode robot costs 4 ore and 16 obsidian.
Blueprint 27: Each ore robot costs 2 ore. Each clay robot costs 3 ore. Each obsidian robot costs 3 ore and 11 clay. Each geode robot costs 3 ore and 14 obsidian.
Blueprint 28: Each ore robot costs 4 ore. Each clay robot costs 4 ore. Each obsidian robot costs 2 ore and 7 clay. Each geode robot costs 4 ore and 13 obsidian.
Blueprint 29: Each ore robot costs 3 ore. Each clay robot costs 4 ore. Each obsidian robot costs 3 ore and 20 clay. Each geode robot costs 3 ore and 14 obsidian.
Blueprint 30: Each ore robot costs 4 ore. Each clay robot costs 3 ore. Each obsidian robot costs 4 ore and 8 clay. Each geode robot costs 2 ore and 8 obsidian.
    """.trimIndent())
    check(2240, result)
}

private fun test(input: String): Int {
    data class Blueprint(
            val id: Int,
            val oreRobotOre: Int,
            val clayRobotOre: Int,
            val obsidianRobotOre: Int,
            val obsidianRobotClay: Int,
            val geodeRobotOre: Int,
            val geodeRobotObsidian: Int
    ) {

        val maxOreRobots = listOf(oreRobotOre, clayRobotOre, obsidianRobotOre, geodeRobotOre).max()!!
        val maxClayRobots = obsidianRobotClay
        val maxObsidianRobots = geodeRobotObsidian
    }

    val blueprints = arrayListOf<Blueprint>()

    val regex = """Blueprint (\d+): Each ore robot costs (\d+) ore. Each clay robot costs (\d+) ore. Each obsidian robot costs (\d+) ore and (\d+) clay. Each geode robot costs (\d+) ore and (\d+) obsidian.""".toRegex()
    for (line in input.split("\n")) {
        val result = regex.find(line)
        val (id, oreRobotOre, clayRobotOre, obsidianRobotOre, obsidianRobotClay, geodeRobotOre, geodeRobotObsidian) = result!!.destructured
        blueprints += Blueprint(
                id.toInt(),
                oreRobotOre.toInt(),
                clayRobotOre.toInt(),
                obsidianRobotOre.toInt(),
                obsidianRobotClay.toInt(),
                geodeRobotOre.toInt(),
                geodeRobotObsidian.toInt()
        )
    }

    data class State(
            val ore: Int = 0,
            val clay: Int = 0,
            val obsidian: Int = 0,
            val geodes: Int = 0,
            val oreRobot: Int = 1,
            val clayRobot: Int = 0,
            val obsidianRobot: Int = 0,
            val geodeRobot: Int = 0,
            val minutes: Int = 0
    ) {
        var prevState: State? = null
    }

    var maxGeodesSolution: State? = null

    fun dfs(blueprint: Blueprint, state: State) {
        if (state.minutes == 32) {
            if (state.geodes > (maxGeodesSolution?.geodes ?: 0)) {
                maxGeodesSolution = state
            }
        } else {
            val currentMinute = state.minutes
            if (currentMinute >= 1 && maxGeodesSolution != null) {
                var s = maxGeodesSolution
                while ((s?.minutes ?: 0) != currentMinute) {
                    s = s?.prevState
                }
                if (s != null) {
                    if (s.geodes - state.geodes > 1) return
                }
            }
            if (state.ore >= blueprint.oreRobotOre) {
                if (state.oreRobot < blueprint.maxOreRobots)
                    dfs(blueprint, State(
                            state.ore + state.oreRobot - blueprint.oreRobotOre,
                            state.clay + state.clayRobot,
                            state.obsidian + state.obsidianRobot,
                            state.geodes + state.geodeRobot,
                            state.oreRobot + 1,
                            state.clayRobot,
                            state.obsidianRobot,
                            state.geodeRobot,
                            state.minutes + 1
                    ).apply { prevState = state })
            }
            if (state.ore >= blueprint.clayRobotOre) {
                if (state.clayRobot < blueprint.maxClayRobots)
                    dfs(blueprint, State(
                            state.ore + state.oreRobot - blueprint.clayRobotOre,
                            state.clay + state.clayRobot,
                            state.obsidian + state.obsidianRobot,
                            state.geodes + state.geodeRobot,
                            state.oreRobot,
                            state.clayRobot + 1,
                            state.obsidianRobot,
                            state.geodeRobot,
                            state.minutes + 1
                    ).apply { prevState = state })
            }
            if (state.ore >= blueprint.obsidianRobotOre && state.clay >= blueprint.obsidianRobotClay) {
                if (state.obsidianRobot < blueprint.maxObsidianRobots)
                    dfs(blueprint, State(
                            state.ore + state.oreRobot - blueprint.obsidianRobotOre,
                            state.clay + state.clayRobot - blueprint.obsidianRobotClay,
                            state.obsidian + state.obsidianRobot,
                            state.geodes + state.geodeRobot,
                            state.oreRobot,
                            state.clayRobot,
                            state.obsidianRobot + 1,
                            state.geodeRobot,
                            state.minutes + 1
                    ).apply { prevState = state })
            }
            if (state.ore >= blueprint.geodeRobotOre && state.obsidian >= blueprint.geodeRobotObsidian) {
                dfs(blueprint, State(
                        state.ore + state.oreRobot - blueprint.geodeRobotOre,
                        state.clay + state.clayRobot,
                        state.obsidian + state.obsidianRobot - blueprint.geodeRobotObsidian,
                        state.geodes + state.geodeRobot,
                        state.oreRobot,
                        state.clayRobot,
                        state.obsidianRobot,
                        state.geodeRobot + 1,
                        state.minutes + 1
                ).apply { prevState = state })
            }
            dfs(blueprint, State(
                    state.ore + state.oreRobot,
                    state.clay + state.clayRobot,
                    state.obsidian + state.obsidianRobot,
                    state.geodes + state.geodeRobot,
                    state.oreRobot,
                    state.clayRobot,
                    state.obsidianRobot,
                    state.geodeRobot,
                    state.minutes + 1
            ).apply { prevState = state })
        }
    }

    return blueprints.subList(0, min(3, blueprints.size)).map { blueprint ->
        maxGeodesSolution = null
        dfs(blueprint, State())
        val maxGeodes = maxGeodesSolution!!.geodes
        println("max geodes is $maxGeodes for blueprint with id ${blueprint.id}")
        maxGeodes
    }.reduce { a, b -> a * b }
}

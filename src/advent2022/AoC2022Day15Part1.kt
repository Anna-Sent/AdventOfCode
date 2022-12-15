package advent2022

import utils.Point

private var result = 0

fun main() {
    result = test(10, """
        Sensor at x=2, y=18: closest beacon is at x=-2, y=15
        Sensor at x=9, y=16: closest beacon is at x=10, y=16
        Sensor at x=13, y=2: closest beacon is at x=15, y=3
        Sensor at x=12, y=14: closest beacon is at x=10, y=16
        Sensor at x=10, y=20: closest beacon is at x=10, y=16
        Sensor at x=14, y=17: closest beacon is at x=10, y=16
        Sensor at x=8, y=7: closest beacon is at x=2, y=10
        Sensor at x=2, y=0: closest beacon is at x=2, y=10
        Sensor at x=0, y=11: closest beacon is at x=2, y=10
        Sensor at x=20, y=14: closest beacon is at x=25, y=17
        Sensor at x=17, y=20: closest beacon is at x=21, y=22
        Sensor at x=16, y=7: closest beacon is at x=15, y=3
        Sensor at x=14, y=3: closest beacon is at x=15, y=3
        Sensor at x=20, y=1: closest beacon is at x=15, y=3
    """.trimIndent())
    check(26, result)

    result = test(2000000, """
        Sensor at x=3482210, y=422224: closest beacon is at x=2273934, y=-202439
        Sensor at x=3679395, y=2737332: closest beacon is at x=4104213, y=2980736
        Sensor at x=3173475, y=3948494: closest beacon is at x=3494250, y=3554521
        Sensor at x=27235, y=3642190: closest beacon is at x=-190885, y=3635525
        Sensor at x=3851721, y=1754784: closest beacon is at x=3145586, y=2167751
        Sensor at x=327074, y=3250656: closest beacon is at x=-190885, y=3635525
        Sensor at x=3499970, y=3186179: closest beacon is at x=3494250, y=3554521
        Sensor at x=150736, y=2522778: closest beacon is at x=-85806, y=2000000
        Sensor at x=3000768, y=3333983: closest beacon is at x=2564067, y=3163630
        Sensor at x=1751302, y=1660540: closest beacon is at x=3145586, y=2167751
        Sensor at x=2591068, y=2923079: closest beacon is at x=2564067, y=3163630
        Sensor at x=48946, y=3999178: closest beacon is at x=-190885, y=3635525
        Sensor at x=3695475, y=3863101: closest beacon is at x=3494250, y=3554521
        Sensor at x=1504031, y=2760: closest beacon is at x=2273934, y=-202439
        Sensor at x=3021186, y=2667125: closest beacon is at x=3145586, y=2167751
        Sensor at x=1514629, y=3771171: closest beacon is at x=2564067, y=3163630
        Sensor at x=234064, y=616106: closest beacon is at x=-85806, y=2000000
        Sensor at x=3990843, y=3393575: closest beacon is at x=4104213, y=2980736
        Sensor at x=768875, y=2665271: closest beacon is at x=-85806, y=2000000
    """.trimIndent())
    check(4811413, result)
}

private fun test(testedY: Int, input: String): Int {
    val regex = """Sensor at x=(-?\d+), y=(-?\d+): closest beacon is at x=(-?\d+), y=(-?\d+)""".toRegex()
    val sensors = mutableSetOf<Point>()
    val beacons = mutableSetOf<Point>()
    val emptyZone = mutableSetOf<Point>()
    for (line in input.split("\n")) {
        val result = regex.find(line)
        val (sensorXStr, sensorYStr, beaconXStr, beaconYStr) = result!!.destructured
        val (sensorX, sensorY, beaconX, beaconY) = listOf(sensorXStr, sensorYStr, beaconXStr, beaconYStr).map { it.toInt() }
        val sensor = Point(sensorX, sensorY).also { sensors += it }
        val beacon = Point(beaconX, beaconY).also { beacons += it }
        val r = sensor.manhattanDistance(beacon)
        if (testedY in sensor.y - r..sensor.y + r) {
            for (x in sensor.x - r..sensor.x + r) {
                Point(x, testedY).also {
                    if (it.manhattanDistance(sensor) <= r) {
                        emptyZone += it
                    }
                }
            }
        }
    }
    return emptyZone.count { it !in beacons }
}

package advent2022

import utils.Point
import kotlin.math.max

private var result = 0L

fun main() {
    result = test(20, """
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
    check(56000011, result)

    result = test(4000000, """
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
    check(13171855019123, result)
}

private fun test(radius: Int, input: String): Long {
    val regex = """Sensor at x=(-?\d+), y=(-?\d+): closest beacon is at x=(-?\d+), y=(-?\d+)""".toRegex()
    val sensors = mutableSetOf<Point>()
    val beacons = mutableSetOf<Point>()
    val xToYSegments = Array(radius + 1) { arrayListOf<Pair<Int, Int>>() }
    var counter = 0
    for (line in input.split("\n")) {
        println("sensor ${counter++}")
        val result = regex.find(line)
        val (sensorXStr, sensorYStr, beaconXStr, beaconYStr) = result!!.destructured
        val (sensorX, sensorY, beaconX, beaconY) = listOf(sensorXStr, sensorYStr, beaconXStr, beaconYStr).map { it.toInt() }
        val sensor = Point(sensorX, sensorY).also { sensors += it }
        val beacon = Point(beaconX, beaconY).also { beacons += it }
        val r = sensor.manhattanDistance(beacon)
        for (delta in -r..0) {
            val x = sensor.x + delta
            if (x in xToYSegments.indices) xToYSegments[x] += sensor.y - delta - r to (r + delta) * 2 + 1
        }
        for (delta in 1..r) {
            val x = sensor.x + delta
            if (x in xToYSegments.indices) xToYSegments[x] += sensor.y + delta - r to (r - delta) * 2 + 1
        }
    }
    var result: Point? = null
    for (x in xToYSegments.indices) {
        val ySegments = xToYSegments[x]
        ySegments.sortBy { it.first }
        var lastY = ySegments[0].first + ySegments[0].second - 1
        for (ySegment in ySegments.subList(1, ySegments.size)) {
            val (y, length) = ySegment
            if (y - lastY > 1) {
                println("y coord ${lastY + 1} x coord $x")
                result = Point(x, lastY + 1)
                break
            } else {
                lastY = max(lastY, y + length - 1)
            }
        }
        if (result != null) break
    }
    return result!!.x * 4000000L + result.y
}

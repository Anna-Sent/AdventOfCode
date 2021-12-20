package advent2021

import utils.Point3D

private var result = 0

fun main() {
    result = test(INPUT_2021_19_1)
    check(79, result)

    result = test(INPUT_2021_19_2)
    check(318, result)

    result = test(INPUT_2021_19_3)
    check(447, result)
}

private fun Scanner.add(other: Scanner, relPoint: Point3D) {
    for (beacon in other.beacons) {
        val point = beacon - relPoint
        if (point !in beacons) beacons += point
    }
}

private fun test(input: String): Int {
    val (positions, scanners) = findPositions(input)
    val result = Scanner(scanners[0])
    for (i in 1 until positions.size) {
        result.add(scanners[i], positions[i])
    }
    return result.beacons.size
}

package utils

enum class Direction {
    L, R, D, U
}

data class Position(
    val point: Point,
    val direction: Direction
)

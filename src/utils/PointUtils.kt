package utils

fun Point.plus(other: Point): Point = Point(x + other.x, y + other.y)

fun Point.plus(x: Int, y: Int): Point = Point(this.x + x, this.y + y)

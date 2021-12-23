package advent2021

private var result = 0

fun main() {
    result = test(
        """#############
#...........#
###B#C#B#D###
  #A#D#C#A#  
  #########  """
    )
    check(12521, result)

    result = test(
        """#############
#...........#
###B#C#C#B###
  #D#D#A#A#  
  #########  """
    )
    check(18051, result)
}

private val endStateConfiguration = """#############
#...........#
###A#B#C#D###
  #A#B#C#D#  
  #########  """

private fun test(input: String): Int {
    return State(input, 0).findPath(endStateConfiguration)!!.energy
}

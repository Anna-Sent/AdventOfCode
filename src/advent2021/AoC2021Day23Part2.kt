package advent2021

private var result = 0

fun main() {
    result = test(
        """#############
#...........#
###B#C#B#D###
  #D#C#B#A#  
  #D#B#A#C#  
  #A#D#C#A#  
  #########  """
    )
    check(44169, result)

    result = test(
        """#############
#...........#
###B#C#C#B###
  #D#C#B#A#  
  #D#B#A#C#  
  #D#D#A#A#  
  #########  """
    )
    check(50245, result)
}

private val endStateConfiguration = """#############
#...........#
###A#B#C#D###
  #A#B#C#D#  
  #A#B#C#D#  
  #A#B#C#D#  
  #########  """

private fun test(input: String): Int {
    return State(input, 0).findPath(endStateConfiguration)!!.energy
}

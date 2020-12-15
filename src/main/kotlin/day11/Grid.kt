package day11

interface Grid {
    fun performAction(action: Char, value: Int)

    fun calculateManhattanDistanceFromOrigin(): Int
}
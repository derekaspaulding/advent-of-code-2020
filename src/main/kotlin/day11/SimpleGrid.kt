package day11

import kotlin.math.*

class SimpleGrid: Grid {
    private var currentPosition = Pair(0, 0)
    private var direction = 90

    override fun performAction(action: Char, value: Int) {
        val (currentX, currentY) = currentPosition

        when (action) {
            'N' -> currentPosition = Pair(currentX, currentY + value)
            'S' -> currentPosition = Pair(currentX, currentY - value)
            'E' -> currentPosition = Pair(currentX + value, currentY)
            'W' -> currentPosition = Pair(currentX - value, currentY)
            'L' -> direction = (direction - value) % 360
            'R' -> direction = (direction + value) % 360
            'F' -> {
                val radians = direction * PI / 180
                val dx = (sin(radians) * value).roundToInt()
                val dy = (cos(radians) * value).roundToInt()

                currentPosition = Pair(currentX + dx, currentY + dy)
            }
        }
    }

    override fun calculateManhattanDistanceFromOrigin(): Int {
        val (x, y) = currentPosition

        return abs(x) + abs(y)
    }
}
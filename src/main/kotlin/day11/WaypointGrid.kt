package day11

import kotlin.math.*

class WaypointGrid: Grid {
    private var waypoint = Pair(10, 1)
    private var currentPosition = Pair(0, 0)

    private fun rotate90Left() {
        val (x, y) = waypoint
        waypoint =  Pair(-y, x)
    }

    private fun rotate90Right() {
        val (x, y) = waypoint
        waypoint =  Pair(y, -x)
    }

    private fun rotateWaypoint(degrees: Int) {
        var degreesLeftToRotate = abs(degrees)
        while(degreesLeftToRotate > 0) {
            if (degrees < 0) {
                rotate90Left()
            } else {
                rotate90Right()
            }

            degreesLeftToRotate -= 90
        }
    }

    override fun performAction(action: Char, value: Int) {
        val (currentX, currentY) = currentPosition
        val (waypointX, waypointY) = waypoint

        when (action) {
            'N' -> waypoint = Pair(waypointX, waypointY + value)
            'S' -> waypoint = Pair(waypointX, waypointY - value)
            'E' -> waypoint = Pair(waypointX + value, waypointY)
            'W' -> waypoint = Pair(waypointX - value, waypointY)
            'L' -> rotateWaypoint(-value)
            'R' -> rotateWaypoint(value)
            'F' -> {
                currentPosition = Pair(
                    currentX + (waypointX * value),
                    currentY + (waypointY * value)
                )
            }
        }
    }

    override fun calculateManhattanDistanceFromOrigin(): Int {
        val (x, y) = currentPosition

        return abs(x) + abs(y)
    }
}
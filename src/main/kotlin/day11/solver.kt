package day11

import java.io.File

fun solveProblem(instructions: List<String>, useWaypoint: Boolean): Int {
    val grid = if(useWaypoint) {
        WaypointGrid()
    } else {
        SimpleGrid()
    }

    for (instruction in instructions) {
        val action = instruction[0]
        val value = instruction.substring(1).toInt()

        grid.performAction(action, value)
    }

    return grid.calculateManhattanDistanceFromOrigin()
}

fun solveProblemOne(instructions: List<String>): Int = solveProblem(instructions, false)

fun solveProblemTwo(instructions: List<String>): Int = solveProblem(instructions, true)

fun main() {
    val instructions = File("src/main/resources/day11/input.txt").useLines { it.toList() }

    val solution1 = solveProblemOne(instructions)
    println("Manhattan distance to final position using simple grid: $solution1")

    val solution2 = solveProblemTwo(instructions)
    println("Manhattan distance to final position using waypoint grid: $solution2")
}
package day3

import java.io.File

fun solveProblemOne(rawGrid: List<String>, slope: Pair<Int, Int> = Pair(1, 3)): Int {
    val grid = Grid(rawGrid)
    var x = 0
    var y = 0
    var trees = 0

    while (y < grid.height) {
        if (grid.isTree(x, y)) {
            trees += 1
        }
        x += slope.second
        y += slope.first
    }

    return trees
}

fun solveProblemTwo(rawGrid: List<String>): List<Int> {
    val slopes = listOf<Pair<Int, Int>>(
        Pair(1, 1),
        Pair(1, 3),
        Pair(1, 5),
        Pair(1, 7),
        Pair(2, 1)
    )

    return slopes
        .map { solveProblemOne(rawGrid, it) }
}

fun main() {
    val grid = File("src/main/resources/day3/input.txt")
        .useLines { it.toList() }

    println("Trees: ${solveProblemOne(grid)}")

    val solution = solveProblemTwo(grid)
    val product = solution.reduce{acc, treeCount -> acc * treeCount}
    val productString = solution.joinToString(separator = " x ") { it.toString() }
    println("$productString = $product")
}

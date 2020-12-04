package day3

import kotlin.IllegalArgumentException

class Grid(private val rawGrid: List<String>) {
    private val grid: List<List<Boolean>> = rawGrid.map { row ->
        row.toList().map { it == '#' }
    }

    init {
        if (!validateRawGrid()) {
            throw IllegalArgumentException("Raw grid must contain rows of same length and only the chars '.' and '#'")
        }
    }

    private fun validateRawGrid() = rawGrid.isNotEmpty() && rawGrid.all {
        it.length == rawGrid[0].length && it.all { char ->
            char == '.' || char == '#'
        }
    }

    val height = rawGrid.size

    fun isTree(x: Int, y: Int) = grid[y][x % grid[0].size]
}
import day3.solveProblemOne
import day3.solveProblemTwo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

val rawInput = listOf(
    "..##.......",
    "#...#...#..",
    ".#....#..#.",
    "..#.#...#.#",
    ".#...##..#.",
    "..#.##.....",
    ".#.#.#....#",
    ".#........#",
    "#.##...#...",
    "#...##....#",
    ".#..#...#.#",
)

class Day3Tests {

    @Test
    fun `solves the first problem`() {
        Assertions.assertEquals(7, solveProblemOne(rawInput))
    }

    @Test
    fun `solves the second problem`() {
        Assertions.assertEquals(listOf(2, 7, 3, 4, 2), solveProblemTwo(rawInput))
    }
}
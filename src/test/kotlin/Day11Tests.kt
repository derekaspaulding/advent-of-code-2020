import day11.solveProblemOne
import day11.solveProblemTwo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

val testInstructions = listOf(
    "F10",
    "N3",
    "F7",
    "R90",
    "F11",
    "E3",
    "S2",
    "L180",
    "F2",
    "R270",
    "F1",
    "W2"
)

val simpleTestInstructions = listOf(
    "F10",
    "N3",
    "F7",
    "R90",
    "F11",
)

class Day11Tests {
    @Test
    fun `solves problem one`() {
        Assertions.assertEquals(25, solveProblemOne(simpleTestInstructions))
    }

    @Test
    fun `solves problem one with complex instructions`() {
        Assertions.assertEquals(25, solveProblemOne(testInstructions))
    }

    @Test
    fun `solves problem 2`() {
        Assertions.assertEquals(286, solveProblemTwo(simpleTestInstructions))
    }

    @Test
    fun `solves problem 2 with complex instructions`() {
        Assertions.assertEquals(243, solveProblemTwo(testInstructions))
    }
}
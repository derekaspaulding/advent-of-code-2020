import day10.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day10Tests {
    @Test
    fun `solves the first problem`() {
        Assertions.assertEquals(220, solveFirstProblem(testJoltages))
    }

    @Test
    fun `solves the second problem with the simple list`() {
        Assertions.assertEquals(8, solveProblemTwo(simpleTestJoltages))
    }

    @Test
    fun `solves the second problem with the complex list`() {
        Assertions.assertEquals(19208, solveProblemTwo(testJoltages))
    }
}

val simpleTestJoltages = listOf(
    16,
    10,
    15,
    5,
    1,
    11,
    7,
    19,
    6,
    12,
    4
)

val testJoltages = listOf(
    28,
    33,
    18,
    42,
    31,
    14,
    46,
    20,
    48,
    47,
    24,
    23,
    49,
    45,
    19,
    38,
    39,
    11,
    1,
    32,
    25,
    35,
    8,
    17,
    7,
    9,
    4,
    2,
    34,
    10,
    3,
)
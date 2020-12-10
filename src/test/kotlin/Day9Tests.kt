import day9.solveFirstProblem
import day9.solveSecondProblem
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

val exampleList = listOf<Long>(
    35,
    20,
    15,
    25,
    47,
    40,
    62,
    55,
    65,
    95,
    102,
    117,
    150,
    182,
    127,
    219,
    299,
    277,
    309,
    576
)

class Day9Tests {
    @Test
    fun `solves the first problem`() {
        Assertions.assertEquals(127, solveFirstProblem(exampleList, 5))
    }

    @Test
    fun `solves the second problem`() {
        Assertions.assertEquals(62, solveSecondProblem(exampleList, 5))
    }
}
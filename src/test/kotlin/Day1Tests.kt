import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import day1.*

val exampleNums = listOf(
    1721,
    979,
    366,
    299,
    675,
    1456,
)

class Day1Tests {
    @Test
    fun `two number solver works`() {
        Assertions.assertEquals(solveForTwoNums(exampleNums), Pair(1721, 299))
    }

    @Test
    fun `three number solver works`() {
        Assertions.assertEquals(solveForThreeNums(exampleNums), Triple(979, 366, 675))
    }
}


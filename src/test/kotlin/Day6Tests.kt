import day6.solveProblemOne
import day6.solveProblemTwo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

val groups: List<List<String>> = listOf(
    listOf("abc"),
    listOf(
        "a",
        "b",
        "c",
    ),
    listOf(
        "ab",
        "ac",
    ),
    listOf(
        "a",
        "a",
        "a",
        "a",
    ),
    listOf("b")
)

class Day6Tests {

    @Test
    fun `solves problem one`() {
        Assertions.assertEquals(11, solveProblemOne(groups))
    }

    @Test
    fun `solves problem two`() {
        Assertions.assertEquals(6, solveProblemTwo(groups))
    }
}
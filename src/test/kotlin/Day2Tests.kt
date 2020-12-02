import org.junit.jupiter.api.Test
import day2.*
import org.junit.jupiter.api.Assertions

val input = listOf(
    "1-3 a: abcde",
    "1-3 b: cdefg",
    "2-9 c: ccccccccc",
)

class Day2Tests {
    @Test
    fun `solves the first problem`() {
        Assertions.assertEquals(2, checkProblemOne(input))
    }

    @Test
    fun `solves the second problem`() {
        Assertions.assertEquals(1, checkProblemTwo(input))
    }
}
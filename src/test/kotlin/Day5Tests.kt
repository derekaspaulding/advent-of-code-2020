import day5.findHighestSeatId
import day5.findMissingSeat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

// Seats 27 - 41 missing 36
val exampleSeats = listOf(
    "FFFFFBBRLL", // 28
    "FFFFFBBLRR", // 27
    "FFFFBFFLRL", // 34
    "FFFFBFBLLL", // 40
    "FFFFBFFLLR", // 33
    "FFFFBFFRRR", // 39
    "FFFFBFFLRR", // 35
    "FFFFBFBLLR", // 41
    "FFFFBFBLLR", // 41
    "FFFFFBBRRR", // 31
    "FFFFFBBRRL", // 30
    "FFFFBFFLLL", // 32
    "FFFFFBBRLR", // 29
    "FFFFBFFRLR", // 37
    "FFFFBFFRRL", // 38
)

class Day5Tests {
    @Test
    fun `solves the first problem`() {
        Assertions.assertEquals(41, findHighestSeatId(exampleSeats))
    }

    @Test
    fun `solves the second problem`() {
        Assertions.assertEquals(36, findMissingSeat(exampleSeats))
    }
}
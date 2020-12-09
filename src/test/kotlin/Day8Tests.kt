import day8.LoopDetected
import day8.solveFirstProblem
import day8.solveSecondProblem
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

val instructions = listOf<String>(
    "nop +0",
    "acc +1",
    "jmp +4",
    "acc +3",
    "jmp -3",
    "acc -99",
    "acc +1",
    "jmp -4",
    "acc +6"
)

class Day8Tests {
    @Test
    fun `solves problem one with the correct accumulator value`() {
        val result = solveFirstProblem(instructions)
        Assertions.assertEquals(
            5,
            result.accumulator
        )
    }

    @Test
    fun `solves problem one with the correct termination reason`() {
        val result = solveFirstProblem(instructions)
        Assertions.assertTrue(result.terminationReason is LoopDetected)
    }

    @Test
    fun `solves problem one with the correct line in the loop result`() {
        val result = solveFirstProblem(instructions)
        val loopLine = (result.terminationReason as LoopDetected).line
        Assertions.assertEquals(2, loopLine)
    }

    @Test
    fun `solves problem two`() {
        Assertions.assertEquals(8, solveSecondProblem(instructions).accumulator)
    }
}
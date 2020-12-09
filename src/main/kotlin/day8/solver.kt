package day8

import java.io.File

fun solveFirstProblem(instructions: List<String>): Result {
    val console = GameConsole(instructions)

    return console.execute()
}

fun solveSecondProblem(instructions: List<String>): Result {

    for ((index) in instructions.withIndex()) {
        val updatedInstructions = changeInstruction(instructions, index) {
            when (it.opCode) {
                "jmp" -> Operation("nop", it.input)
                "nop" -> Operation("jmp", it.input)
                else -> it
            }
        }

        val console = GameConsole(updatedInstructions)
        val result = console.execute()

        if (result.terminationReason is EndOfFile) {
            return result
        }
    }

    throw IllegalStateException("No change to the program allowed it to complete")
}

fun main() {
    val instructions = File("src/main/resources/day8/input.txt").useLines { it.toList() }

    val problemOneResult = solveFirstProblem(instructions)
    if (problemOneResult.terminationReason is LoopDetected) {
        println("Loop detected on line ${problemOneResult.terminationReason.line}. Accumulator value was: ${problemOneResult.accumulator}")
    }

    val problemTwoResult = solveSecondProblem(instructions)
    println("Fixed instructions end with accumulator value: ${problemTwoResult.accumulator}")
}
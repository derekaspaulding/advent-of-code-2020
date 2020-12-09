package day8

sealed class TerminationReason
object EndOfFile : TerminationReason()
data class LoopDetected(val line: Int) : TerminationReason()

data class Operation(val opCode: String, val input: Int)

data class Result(val accumulator: Int, val terminationReason: TerminationReason)

fun changeInstruction(instructions: List<String>, line: Int, updateOp: (Operation) -> Operation): List<String> {
    if (line >= instructions.size) {
        throw IllegalArgumentException("$line is out of range of the instruction set")
    }

    val (op, inputString) = instructions[line].split(" ")
    val input = inputString.toInt()

    val oldOperation = Operation(op, input)
    val newOp = updateOp(oldOperation)

    return instructions.mapIndexed { index, instruction ->
        if (index == line) {
            val newInputString = if (newOp.input >= 0) {
                "+${newOp.input}"
            } else {
                newOp.input.toString()
            }
            "${newOp.opCode} $newInputString"
        } else {
            instruction
        }
    }
}

class GameConsole(private var instructions: List<String>) {
    private var accumulator = 0
    private var programCounter = 0
    private val executedLines = mutableSetOf<Int>()

    private fun executeInstructionAtProgramCounter() {
        val instruction = instructions[programCounter]
        val (op, inputString) = instruction.split(" ")
        val input = inputString.toInt()

        when (op) {
            "nop" -> programCounter += 1
            "acc" -> {
                programCounter += 1
                accumulator += input
            }
            "jmp" -> programCounter += input
            else -> throw IllegalArgumentException("Unknown operation: $op")
        }
    }




    fun execute(): Result {
        while (true) {
            if (programCounter >= instructions.size) {
                return Result(accumulator, EndOfFile)
            }

            if (executedLines.contains(programCounter)) {
                return Result(accumulator, LoopDetected(programCounter + 1))
            }

            executedLines.add(programCounter)
            executeInstructionAtProgramCounter()
        }
    }
}
package day9

import java.io.File

fun solveFirstProblem(numbers: List<Long>, preambleLength: Int = 25): Long? = numbers
    .subList(preambleLength, numbers.size)
    .withIndex()
    .find {
        val (index, num) = it
        val i2Start = index + 1
        val end = index + preambleLength
        for (i1 in index..end) {
            for (i2 in i2Start..end) {
                if (numbers[i1] + numbers[i2] == num) {
                    return@find false
                }
            }
        }

        true
    }?.value

fun findSecondProblemSublist(numbers: List<Long>, target: Long): List<Long>? {
    for (len in 2..numbers.size) {
        for (i in 0..(numbers.size - len)) {
            val subList = numbers.subList(i, i + len)
            if (subList.reduce { acc, number -> acc + number} == target) {
                return subList
            }
        }
    }

    return null
}

fun solveSecondProblem(numbers: List<Long>, preambleLength: Int = 25): Long? {
    val target = solveFirstProblem(numbers, preambleLength) ?: return null
    val subList = findSecondProblemSublist(numbers, target) ?: return null

    val min = subList.minOrNull() ?: return null
    val max = subList.maxOrNull() ?: return null

    return min + max
}

fun main() {
    val numbers = File("src/main/resources/day9/input.txt")
        .useLines { it.toList() }
        .map { it.toLong() }

    val incorrectNumber = solveFirstProblem(numbers)
    println("First number not following the rule: $incorrectNumber")

    val weakness = solveSecondProblem(numbers)
    println("XMAS-encryption weakness: $weakness")
}
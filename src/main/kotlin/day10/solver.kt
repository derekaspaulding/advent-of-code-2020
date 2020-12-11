package day10

import java.io.File

fun buildJoltageAdapterChain(joltages: List<Int>) = joltages.sorted()

fun solveFirstProblem(joltages: List<Int>): Int {
    val chain = buildJoltageAdapterChain(joltages)
    var oneJoltDifferences = 0
    // There is always a final 3 jolt difference from the end of the chain to the device
    var threeJoltDifferences = 1
    for (i in 0..chain.lastIndex) {
        // getOrNull handles the first element that doesn't have an element before it
        val joltageDifference = chain[i] - (chain.getOrNull(i - 1) ?: 0)
        if (joltageDifference == 1) {
            oneJoltDifferences += 1
        } else if (joltageDifference == 3) {
            threeJoltDifferences += 1
        }
    }

    return oneJoltDifferences * threeJoltDifferences
}

fun solveProblemTwo(joltages: List<Int>): Long {
    val comboMap = mutableMapOf<Int, Long>()
    var lookupHits = 0
    fun getCombinations(
        lastJoltage: Int,
        remainingJoltages: List<Int>,
    ): Long {
        if (remainingJoltages.isEmpty()) {
            // When we are out of adapters, there's the final connection to the
            return 1
        }

        val lookupValue = comboMap[remainingJoltages.hashCode()]
        if (lookupValue != null) {
            lookupHits += 1
            return lookupValue
        }

        val possibleCombinations = remainingJoltages.withIndex()
            .filter { it.value - lastJoltage <= 3 }
            .map { Pair(it.value, remainingJoltages.subList(it.index + 1, remainingJoltages.size)) }

        val nextCombinations = possibleCombinations.map {
            val combo = getCombinations(it.first, it.second)
            comboMap[it.second.hashCode()] = combo
            combo
        }

        return nextCombinations.reduce { acc, combo -> acc + combo }
    }

    val chain = buildJoltageAdapterChain(joltages)

    return getCombinations(0, chain)
}

fun main() {
    val joltages = File("src/main/resources/day10/input.txt")
        .useLines { it.toList() }
        .map { it.toInt() }

    val solution1 = solveFirstProblem(joltages)
    println("Product of 1 jolt and 3 jolt differences: $solution1")

    val combinations = solveProblemTwo(joltages)
    println("Possible combinations: $combinations")
}
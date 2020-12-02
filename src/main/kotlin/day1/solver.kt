package day1

import java.io.File
import java.lang.IllegalArgumentException

fun solveForTwoNums(nums: List<Int>, target: Int = 2020): Pair<Int, Int> {
    for ((index, num1) in nums.withIndex()) {
        if (index != nums.lastIndex) {
            for (num2 in nums.subList(index + 1, nums.size)) {
                if (num1 + num2 == target) {
                    return Pair(num1, num2)
                }
            }
        }
    }

    throw IllegalArgumentException("Given list does not contain a solution")
}

fun solveForThreeNums(nums: List<Int>): Triple<Int, Int, Int> {
    for ((index, num1) in nums.withIndex()) {
        if (index + 1 != nums.lastIndex) {
            try {
                val (num2, num3) = solveForTwoNums(nums.subList(index + 1, nums.size), 2020 - num1)
                return Triple(num1, num2, num3)
            } catch (e: IllegalArgumentException) {
                continue
            }
        }
    }

    throw IllegalArgumentException("Given list does not contain a solution")
}

fun main() {
    val nums = File("src/main/resources/day1/input.txt")
        .useLines { it.toList() }
        .map { it.toInt() }

    val (twoNum1, twoNum2) = solveForTwoNums(nums)
    val twoNumProduct = twoNum1 * twoNum2
    println("$twoNum1 x $twoNum2 = $twoNumProduct")


    val (threeNum1, threeNum2, threeNum3) = solveForThreeNums(nums)
    val threeNumProduct = threeNum1 * threeNum2 * threeNum3
    println("$threeNum1 x $threeNum2 x $threeNum3 = $threeNumProduct")

}
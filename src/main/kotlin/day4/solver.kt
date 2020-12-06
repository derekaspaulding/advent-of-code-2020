package day4

import java.io.File

fun getPassports(batch: String, shouldValidate: Boolean = false): List<Passport> = batch
    .split("\n\n")
    .map { Passport(it, shouldValidate) }

fun solveFirstProblem(batch: String): Int = getPassports(batch).count { it.isValid() }

fun solveSecondProblem(batch: String): Int = getPassports(batch, true).count { it.isValid() }

fun main() {
    val batchInput = File("src/main/resources/day4/input.txt").readText(Charsets.UTF_8)

    println("Passports With All Fields: ${solveFirstProblem(batchInput)}")
    println("Passports With All Valid Fields: ${solveSecondProblem(batchInput)}")

}
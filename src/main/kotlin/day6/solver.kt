package day6

import java.io.File

fun solveProblemOne(groups: List<List<String>>): Int = groups.fold(0,  {sum, group ->
    val charSet = mutableSetOf<Char>()

    for (answer in group) {
        for (char in answer) {
            charSet.add(char)
        }
    }

    sum + charSet.size
})

fun solveProblemTwo(groups: List<List<String>>): Int = groups.fold(0,  {sum, group ->
    val charSet = mutableSetOf<Char>()

    for (answer in group) {
        for (char in answer) {
            if (group.all { a -> a.contains(char) }) {
                charSet.add(char)
            }
        }
    }

    sum + charSet.size
})

fun main() {
    val inputText = File("src/main/resources/day6/input.txt").readText()
    val groups = inputText.split("\n\n").map { it.split("\n") }

    println("Sum where anyone answered yes: ${solveProblemOne(groups)}")
    println("Sum where everyone answered yes: ${solveProblemTwo(groups)}")

}

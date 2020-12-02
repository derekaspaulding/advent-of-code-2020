package day2

import java.io.File

fun parse(passwordSpec: String): Triple<Pair<Int, Int>, Char, String> {
    val (bounds, characterSpec, password) = passwordSpec.split(" ")
    val (min, max) = bounds.split("-").map { bound -> bound.toInt() }
    val character = characterSpec[0]

    return Triple(Pair(min, max), character, password)
}

fun checkProblemOne(passwords:List<String>): Int = passwords.count {
    val (bounds, character, password) = parse(it)
    val (min, max) = bounds
    val charCount = password.count{ char -> char == character}

    charCount in min..max
}

fun checkProblemTwo(passwords: List<String>): Int = passwords.count {
    val (indices, character, password) = parse(it)
    val (firstChar, secondChar) = indices.toList().map { i -> password[i - 1] } // indices in input are 1 based

    firstChar != secondChar && (firstChar == character || secondChar == character)
}


fun main() {
    val passwords = File("src/main/resources/day2/input.txt")
        .useLines { it.toList() }

    println("First criteria matches: ${checkProblemOne(passwords)} of ${passwords.size}")
    println("Second criteria matches: ${checkProblemTwo(passwords)} of ${passwords.size}")
}
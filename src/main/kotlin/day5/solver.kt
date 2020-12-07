package day5

import java.io.File
import kotlin.math.pow

fun getSeatId(seat: Pair<Int, Int>) = seat.first * 8 + seat.second

fun getSeatLocation(seatDescription: String): Pair<Int, Int> {
    var row = 0
    var column = 0

    for ((index, char) in seatDescription.substring(0, 7).reversed().withIndex()) {
        if (char == 'B') {
            row += 2.0.pow(index).toInt()
        }
    }

    for((index, char) in seatDescription.substring(7).reversed().withIndex()) {
        if (char == 'R') {
            column += 2.0.pow(index).toInt()
        }
    }

    return Pair(row, column)
}

fun findHighestSeatId(seatDescriptions: List<String>) = seatDescriptions
    .map { getSeatId(getSeatLocation(it)) }
    .reduce { acc, i -> if (i > acc) { i } else { acc} }

fun findMissingSeat(seatDescriptions: List<String>): Int {
    val seatIds = seatDescriptions.map { getSeatId(getSeatLocation(it)) }.sorted()

    for ((index, seat) in seatIds.withIndex()) {
        val nextSeat = seat + 1
        if (index + 1 < seatIds.size && seatIds[index + 1] != nextSeat) {
            return nextSeat
        }
    }

    return -1
}

fun main() {
    val seatDescriptions = File("src/main/resources/day5/input.txt")
        .useLines{ it.toList() }

    println("Greatest Seat ID: ${findHighestSeatId(seatDescriptions)}")
    println("Your Seat: ${findMissingSeat(seatDescriptions)}")
}
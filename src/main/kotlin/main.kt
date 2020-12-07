import day1.main as day1
import day2.main as day2
import day3.main as day3
import day4.main as day4
import day5.main as day5

fun solve(day: String, solver: () -> Unit) {
    println("🎄🎄 ${day.capitalize()} 🎄🎄")
    solver()
    println()
}

fun main() {
    solve("Day 1", ::day1)
    solve("Day 2", ::day2)
    solve("Day 3", ::day3)
    solve("Day4", ::day4)
    solve("Day 5", ::day5)
}
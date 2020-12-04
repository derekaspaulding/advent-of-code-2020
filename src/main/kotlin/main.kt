import day1.main as day1
import day2.main as day2
import day3.main as day3

fun solve(day: String, solver: () -> Unit) {
    println("🎄🎄 ${day.capitalize()} 🎄🎄")
    solver()
    println()
}

fun main() {
    solve("Day 1", ::day1)
    solve("Day 2", ::day2)
    solve("Day 3", ::day3)
}
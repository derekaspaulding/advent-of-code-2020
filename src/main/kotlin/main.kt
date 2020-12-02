import day1.main as day1
import day2.main as day2

fun solve(day: String, solver: () -> Unit) {
    println("🎄🎄 ${day.capitalize()} 🎄🎄")
    solver()
    println()
}

fun main() {
    solve("Day 1", ::day1)
    solve("Day 2", ::day2)
}
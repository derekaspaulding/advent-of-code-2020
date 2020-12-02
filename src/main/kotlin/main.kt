import day1.main as day1

fun solve(day: String, solver: () -> Unit) {
    println("🎄🎄 ${day.capitalize()} 🎄🎄")
    solver()
    println()
}

fun main() {
    solve("Day 1", ::day1)
}
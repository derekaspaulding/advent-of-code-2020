import day1.main as day1
import day2.main as day2
import day3.main as day3
import day4.main as day4
import day5.main as day5
import day6.main as day6
import day7.main as day7
import day8.main as day8
import day9.main as day9
import day10.main as day10

fun solve(day: String, solver: () -> Unit) {
    println("🎄🎄 ${day.capitalize()} 🎄🎄")
    solver()
    println()
}

fun main() {
    solve("Day 1", ::day1)
    solve("Day 2", ::day2)
    solve("Day 3", ::day3)
    solve("Day 4", ::day4)
    solve("Day 5", ::day5)
    solve("Day 6", ::day6)
    solve("Day 7", ::day7)
    solve("Day 8", ::day8)
    solve("Day 9", ::day9)
    solve("Day 10", ::day10)
}
package day7

import java.io.File

typealias RuleSet = Map<String, List<Pair<String, Int>>>

val BAG_REGEX = Regex("(^|no|\\d).+?(?=\\sbags?)")

fun parseRuleset(rules: List<String>): RuleSet {
    var ruleSet: RuleSet = mapOf()

    for (rule in rules) {
        val bagDescriptions = BAG_REGEX.findAll(rule).toList().map { it.value }
        ruleSet = ruleSet + mapOf(
            bagDescriptions[0] to bagDescriptions
                .subList(1, bagDescriptions.size)
                .filter { it != "no other" }
                .map {
                    val (num, description) = it.split(" ", limit = 2)
                    Pair(description, num.toInt())
                }
        )
    }

    return ruleSet
}

fun canCarryShinyGoldBag(ruleSet: RuleSet, bag: String): Boolean {
    val rules = ruleSet[bag] ?: listOf()

    return rules.any {
        it.first == "shiny gold" ||
                canCarryShinyGoldBag(ruleSet, it.first)
    }
}

fun solveProblemOne(ruleList: List<String>): List<String> {
    val ruleSet = parseRuleset(ruleList)
    return ruleSet.keys.filter {
        canCarryShinyGoldBag(ruleSet, it)
    }
}

fun getInnerBags(ruleSet: RuleSet, bag: String): Int {
    val rules = ruleSet[bag] ?: listOf()

    return rules.fold(0, { acc, pair ->
        val (innerBag, num) = pair
        acc + num + (num * getInnerBags(ruleSet, innerBag))
    })
}

fun solveProblemTwo(ruleList: List<String>): Int {
    val ruleSet = parseRuleset(ruleList)

    return getInnerBags(ruleSet, "shiny gold")
}

fun main() {
    val ruleList = File("src/main/resources/day7/input.txt").useLines { it.toList() }
    val firstSolution = solveProblemOne(ruleList)

    println("${firstSolution.size} bags can hold a shiny gold bag")
    println("a shiny gold bag must contain ${solveProblemTwo(ruleList)} other bags")
}



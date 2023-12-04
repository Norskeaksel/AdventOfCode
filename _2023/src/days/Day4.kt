package days

import java.lang.Math.pow


fun findMatchingNumbers(input: List<String>): Int {
    var score = 0.0
    input.forEach { line ->
        val (winning, yours) = cards(line)
        var streak = -1.0
        yours.forEach {
            if (it in winning)
                streak++
        }
        if (streak >= 0)
            score += pow(2.0, streak)
    }
    return score.toInt()
}

fun buildStackOfCards(input: List<String>): Int {
    val cards = mutableListOf<MutableList<Set<Int>>>()
    cards.addAll((input.indices).map { mutableListOf() })
    input.forEachIndexed { i, line ->
        val (winning, yours) = cards(line)
        cards[i].add(yours.toSet())
        val list = cards[i]
        val streak = list[0].toSet().intersect(winning).size
        for (new in i + 1..i + streak) {
            val (_, newYours) = cards(input[new])
            repeat(list.size) {
                if(it == 0)
                    cards[new].add(newYours.toSet())
                else
                    cards[new].add(emptySet())
            }
        }
    }
    return cards.sumOf { it.size }
}

private fun cards(line: String): Pair<List<Int>, List<Int>> {
    val (left, right) = line.split("|")
    val winning = left.split(":")[1].trim().split("\\s+".toRegex()).map { it.toInt() }
    val yours = right.trim().split("\\s+".toRegex()).map { it.toInt() }
    return Pair(winning, yours)
}

fun main() {
    val input = readFileLines("_2023/inputFiles/Day4")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(findMatchingNumbers(input))
    println(buildStackOfCards(input))
}


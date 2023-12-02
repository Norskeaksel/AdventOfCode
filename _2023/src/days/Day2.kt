package days

import java.lang.Math.max

fun validGames(input: List<String>): Int {
    var sum = 0
    var g = 0
    input.forEach line@{
        g++
        it.split(";").forEach { set ->
            val reds = findNumberFollowedByWord(set, "red")
            val greens = findNumberFollowedByWord(set, "green")
            val blues = findNumberFollowedByWord(set, "blue")
            if(reds > 12 || greens > 13 || blues > 14)
                return@line
        }
        sum += g
    }
    return sum
}

fun findNumberFollowedByWord(input: String, targetWord: String): Int {
    val regex = Regex("(\\d+) ($targetWord)")
    val matchResult = regex.find(input)
    return matchResult?.groupValues?.get(1)?.toInt() ?: 0

    /* return matchResult?.let {
        val number = it.groupValues[1]
        val word = it.groupValues[2]
        Pair(number, word)
    }*/
}

fun minimumCubes(input: List<String>): Int {
    var sum = 0
    input.forEach line@{
        var maxRed = 0
        var maxGreen = 0
        var maxBlue = 0
        it.split(";").forEach { set ->
            val reds = findNumberFollowedByWord(set, "red")
            val greens = findNumberFollowedByWord(set, "green")
            val blues = findNumberFollowedByWord(set, "blue")
            maxRed = max(maxRed, reds)
            maxGreen = max(maxGreen, greens)
            maxBlue = max(maxBlue, blues)
        }
        sum += maxRed*maxGreen*maxBlue
    }
    return sum
}

fun main() {
    val input = readFileLines("_2023/inputFiles/Day2")
    println(validGames(input))
    println(minimumCubes(input))
}


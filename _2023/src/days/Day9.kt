package days

import kotlin.math.abs

fun day9(input: List<String>): Long {
    var ans = 0L
    input.forEach { line ->
        val numbers = line.split(" ").map { it.toInt() }
        var lastNumber = numbers.last()
        var differences = numbers.windowed(2) { (a, b) -> b - a }.toMutableList()
        while (differences.sumOf { abs(it) } != 0) {
            lastNumber += differences.last()
            differences = differences.windowed(2) { (a, b) -> b - a }.toMutableList()
        }
        ans += lastNumber
    }
    return ans
}

fun day92(input: List<String>): Long {
    val reversedInput = mutableListOf<String>()
    input.forEach { line ->
        val reverse = line.split(" ").reversed().joinToString(" ")
        reversedInput.add(reverse)
    }
    return day9(reversedInput)
}

fun main() {
    val input = readFileLines("_2023/inputFiles/day9")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day9(input))
    println(day92(input))
}


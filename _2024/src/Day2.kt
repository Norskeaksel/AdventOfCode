package days

import kotlin.math.abs

fun day2a(input: List<String>): Int {
    var ans = 0
    input.forEach { line ->
        val arr = line.split(" ").map { it.toInt() }
        if (isSafe(arr)) {
            println(arr)
            ans++
        }
    }
    return ans
}

fun isSafe(arr: List<Int>): Boolean {
    val a = arr.sorted()
    val b = arr.sortedDescending()
    if (arr != a && arr != b)
        return false
    for (i in 0 until arr.size - 1) {
        if (abs(arr[i + 1] - arr[i]) !in 1..3) {
            return false
        }
    }

    return true
}

fun day2b(input: List<String>): Int {
    var ans = 0
    input.forEach { line ->
        val arr = line.split(" ").map { it.toInt() }
        if (isSafe(arr)) {
            ans++
            return@forEach
        }
        for (i in 0 until arr.size) {
            val arr2 = arr.toMutableList()
            arr2.removeAt(i)
            if (isSafe(arr2)) {
                ans++
                return@forEach
            }
        }
    }
    return ans
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day2")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day2a(input))
    println(day2b(input))
}
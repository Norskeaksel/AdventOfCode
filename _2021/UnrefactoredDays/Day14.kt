package Days

import java.lang.StrictMath.abs
import java.lang.StrictMath.min

fun part1(input: List<String>, steps: Int): Int {
    var str = input[0]
    val rule = mutableMapOf<String, String>()
    for (i in 1 until input.size) {
        val words = input[i].split(" ")
        val left = words[0]
        val right = words[1]
        rule[left] = left[0] + right + left[1]
    }
    for (k in 1..steps) {
        var i = -1
        while (++i < str.length - 1) {
            val letters = str.substring(i, i + 2)
            rule[letters]?.let {
                str = str.replaceRange(i, i + 2, it)
                i++
            }
        }
        println(k)
    }
    val numbersByElement = str.toCharArray().toList().groupingBy { it }.eachCount()//.remove("")
    val mostCommonElementFrequency = numbersByElement.maxByOrNull { it.value }?.value
    val leastCommonElementFrequency = numbersByElement.minByOrNull { it.value }?.value
    if (mostCommonElementFrequency != null && leastCommonElementFrequency != null)
            return mostCommonElementFrequency - leastCommonElementFrequency

    return -1
}


fun part2(input: List<String>): Long {
    /*var str = input[0]
    val counter = mutableMapOf<Char, Long>()
    val rule = mutableMapOf<String, String>()
    for (i in 1 until input.size) {
        val words = input[i].split(" ")
        val left = words[0]
        val right = words[1]
        rule[left] = left[0] + right + left[1]
    }
    for (k in 1..steps) {
        var i = -1
        while (++i < str.length - 1) {
            val letters = str.substring(i, i + 2)
            rule[letters]?.let {
                str = str.replaceRange(i, i + 2, it)
                i++
            }
        }
        println(str)
    }
    val numbersByElement = str.toCharArray().toList().groupingBy { it }.eachCount()//.remove("")
    val mostCommonElementFrequency = numbersByElement.maxByOrNull { it.value }?.value
    val leastCommonElementFrequency = numbersByElement.minByOrNull { it.value }?.value
    if (mostCommonElementFrequency != null && leastCommonElementFrequency != null)
        return mostCommonElementFrequency - leastCommonElementFrequency*/

    return -1
}


fun main(args: Array<String>) {
    val path = "src/inputFiles/day14.txt"
    val input = readFileLns(path)
    val ans1 = part1(input, 10)
    println("Part 1 = $ans1")
    val ans2 = part2(input)
    println("Part 2 = $ans2")
}


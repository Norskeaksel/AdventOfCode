package days


fun day3a(input: List<String>): Int {
    var ans = 0
    val acceptableInput = mutableSetOf<String>()
    for (i in 0 until 1000) {
        for (j in 0 until 1000) {
            acceptableInput.add("mul($i,$j)")
        }
    }
    input.forEach { line ->
        for (ai in acceptableInput) {
            if (ai in line) {
                val (a, b) = ai.split(",")
                val add = a.filter { it.isDigit() }.toInt() * b.filter { it.isDigit() }.toInt()
                ans += add
            }
        }
    }
    return ans
}

fun day3b(input: List<String>): Int {
    // Only works if input has size 1, meaning the puzzleinput has been edited 2 be on 1 line
    val input2 = mutableListOf<String>()
    input.forEach { line ->
        val sp = line.split("do")
        var i = -1
        while (++i < sp.size) {
            if (!sp[i].contains("n't()")) {
                input2.add(sp[i])
            }
        }
    }
    return day3a(input2)
}

fun main() {
    val input = readFileLines("/home/highruler/Dokumenter/Kotlin/AdventOfCode/_2024/inputFiles/Day3")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day3a(input))
    println(day3b(input))
}
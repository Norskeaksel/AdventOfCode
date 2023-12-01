package days

fun test(ans: Any, expected: Any) {
    if (ans != expected) {
        throw Exception("ans: $ans, Expected: $expected")
    }
}

fun completeOverlap(input: List<String>): Int {
    var ans = 0
    input.forEach {
        val (min1, max1, min2, max2) = it.split(",", "-").map { it.toInt() }
        if((min1<=min2 && max1>=max2) ||(min2<=min1 && max2>=max1))
            ans++
    }
    return ans
}

fun partialOverlap(input: List<String>): Int {
    var ans = 0
    input.forEach {
        val (min1, max1, min2, max2) = it.split(",", "-").map { it.toInt() }
        if((min2 in min1..max1) ||(min1 in min2..max2))
            ans++
    }
    return ans
}

fun main() {
    val inputTest = readFileLines("_2022/src/inputFiles/TestDay4")
    test(completeOverlap(inputTest), 2)
    test(partialOverlap(inputTest), 4)

    val input = readFileLines("_2022/src/inputFiles/RealDay4")
    println("Part 1: ${completeOverlap(input)}")
    println("Part 2: ${partialOverlap(input)}")
}

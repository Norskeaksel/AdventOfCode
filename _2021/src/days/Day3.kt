package days

fun mostCommonChars1(input: List<String>): Int {
    val bits = input[0].indices
    var gamma = ""
    var epsilon = ""
    for (i in bits) {
        val ones = input.count { it[i] == '1' }
        val zeroes = input.count { it[i] == '0' }
        if (ones > zeroes) {
            gamma += '1'
            epsilon += '0'
        } else {
            epsilon += '1'
            gamma += '0'
        }
    }
    return gamma.toInt(2) * epsilon.toInt(2)
}

fun mostCommonChars2(input: List<String>): String {
    fun filterBinaryStrings(oxygen: Boolean = true): String {
        var candidates = input
        val bits = input[0].indices
        for (i in bits) {
            if (candidates.size == 1)
                break
            val ones = candidates.count { it[i] == '1' }
            val zeroes = candidates.count { it[i] == '0' }
            if (oxygen) {
                candidates = if (ones >= zeroes)
                    candidates.filter { it[i] == '1' }
                else
                    candidates.filter { it[i] == '0' }
            } else {
                candidates = if (ones < zeroes)
                    candidates.filter { it[i] == '1' }
                else
                    candidates.filter { it[i] == '0' }
            }
        }
        return candidates.single()
    }

    val oxygenRating = filterBinaryStrings()
    val CO2rating = filterBinaryStrings(false)
    return oxygenRating + "o " + CO2rating + "c"
}

fun main(args: Array<String>) {
    val path = "_2021/src/inputFiles/day3.txt"
    val input = readFileLines(path)
    val ans1 = mostCommonChars1(input)
    println("Part 1 = $ans1")
    val ans2 = mostCommonChars2(input)
    println("Part 2 = $ans2")
    println("011110111101".toInt(2) * "110100101011".toInt(2))
}

package days

fun day5a(input: List<String>): Int {
    val (rules, pageNumbers) = readInput(input)
    var ans = 0
    pageNumbers.forEach { list ->
        if (list.isOrdered(rules))
            ans += list[list.size / 2]
    }
    return ans
}

fun List<Int>.isOrdered(rules: MutableMap<Int, MutableSet<Int>>): Boolean {
    val numbers = mutableSetOf<Int>()
    for (nr in this) {
        val intersection = rules[nr]!!.intersect(numbers)
        if (intersection.isNotEmpty())
            return false
        numbers.add(nr)
    }
    return true
}

fun day5b(input: List<String>): Int {
    val (rules, pageNumbers) = readInput(input)
    var ans = 0
    pageNumbers.forEach { list ->
        if (list.isOrdered(rules))
            return@forEach

        ans += list[list.size / 2]
    }
    return ans
}

private fun readInput(input: List<String>): Pair<MutableMap<Int, MutableSet<Int>>, MutableList<List<Int>>> {
    val rules = mutableMapOf<Int, MutableSet<Int>>()
    var hasNotBeenLineBreak = true
    val pageNumbers = mutableListOf<List<Int>>()
    input.forEach { line ->
        if (line.isBlank()) {
            hasNotBeenLineBreak = false
            return@forEach
        }

        if (hasNotBeenLineBreak) {
            val (a, b) = line.split("|").map { it.toInt() }
            if (!rules.containsKey(a)) {
                rules[a] = mutableSetOf()
            }
            if (!rules.containsKey(b)) {
                rules[b] = mutableSetOf()
            }
            rules[a]!!.add(b)
        } else {
            pageNumbers.add(line.split(",").map { it.toInt() })
        }
    }
    return Pair(rules, pageNumbers)
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day5")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day5a(input))
    println(day5b(input))
}
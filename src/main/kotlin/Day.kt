fun test(ans: Any, expected: Any) {
    if (ans != expected) {
        throw Exception("ans: $ans, Expected: $expected")
    }
}

fun solve1(input: List<String>): Int {
    var ans=0
    val groupAns = mutableSetOf<Char>()
    input.forEach {
        if(it==""){
            ans+=groupAns.size
            groupAns.clear()
        }
        else {
            groupAns.addAll(it.toList())
        }
    }
    return ans
}

fun solve2(input: List<String>): Int {
    var ans=0
    val groupAns = mutableListOf<Set<Char>>()
    input.forEach {
        if(it==""){
            val remainingSet = groupAns.reduce { a,b -> a.intersect(b) }
            ans+=remainingSet.size
            groupAns.clear()
        }
        else {
            groupAns.add(it.toList().toSet())
        }
    }
    return ans
}

fun main() {
    val inputTest = readFileLines("src/main/kotlin/TestDay")
    test(solve1(inputTest), 11)
    test(solve2(inputTest), 6)

    val input = readFileLines("src/main/kotlin/RealDay")
    println("Part 1: ${solve1(input)}")
    println("Part 2: ${solve2(input)}")
}

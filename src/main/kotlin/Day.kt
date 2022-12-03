fun test(expected:Any,ans:Any){
    if (expected!=ans){
        throw Exception("Expected: $expected, ans: $ans")
    }
}
fun solve1(input: List<String>):Int{
    return 0
}

fun solve2(input: List<String>): Int {
    return 0
}

fun main() {
    val inputTest = readFileLines("src/main/kotlin/TestDay")
    test(solve1(inputTest),0)
    test(solve2(inputTest),0)

    val input = readFileLines("src/main/kotlin/RealDay")
    println("Part 1: ${solve1(input)}")
    println("Part 2: ${solve2(input)}")
}

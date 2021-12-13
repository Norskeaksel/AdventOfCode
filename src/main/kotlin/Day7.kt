import java.lang.StrictMath.abs

fun part1(input: List<Int>): Int {
    val median = input.sorted()[input.size/2]
    var ans = 0
    input.forEach { ans+= abs(it-median) }
    return ans
}


fun part2(input: List<Int>): Int {
    return -1
}


fun main(args: Array<String>) {
    val path = "src/inputFiles/day7.txt"
    val input = readFileIntLns(path)
    val ans1 = part1(input)
    println("Part 1 = $ans1")
    val ans2 = part2(input)
    println("Part 2 = $ans2")
}


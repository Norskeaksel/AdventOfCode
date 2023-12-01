package days

fun countIncreases(input: List<Int>) = input.windowed(2).count{(a,b) -> a<b}

fun countSlidingWindowIncreases(input: List<Int>):Int{
    return input.windowed(3).windowed(2).count { (a,b) -> a.sum() <b.sum() }
}

fun main(args: Array<String>) {
    val path = "_2021/src/inputFiles/d1.txt"
    val input = readFileIntLines(path)
    val ans1 = countIncreases(input)
    val ans2 = countSlidingWindowIncreases(input)
    println("Part 1 = $ans1")
    println("Part 2 = $ans2")
}

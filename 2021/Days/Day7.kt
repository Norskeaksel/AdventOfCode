import java.lang.StrictMath.abs
import java.lang.StrictMath.min

fun part1(input: List<Int>): Int {
    val median = input.sorted()[input.size/2]
    var ans = 0
    input.forEach { ans+= abs(it-median) }
    return ans
}


fun part2(input: List<Int>): Long {
    val floor = input.sorted()[0]
    val ceil = input.sorted()[input.size-1]
    val distance = mutableListOf<Int>()
    for (i in floor..ceil){
        distance.add(0)
    }
    input.forEach {
        for (j in floor..ceil){
            val dist = abs(it-j)
            distance[j]+= dist*(dist+1)/2
        }
    }
    var ans =9999999999L
    distance.forEach {
        ans=min(ans,it.toLong())
    }
    return ans
}


fun main(args: Array<String>) {
    val path = "src/inputFiles/day7.txt"
    val input = readFileIntLns(path)
    val ans1 = part1(input)
    println("Part 1 = $ans1")
    val ans2 = part2(input)
    println("Part 2 = $ans2")
}


import java.io.File
import kotlin.math.max

fun part1(input: List<Int>):Int{
    return input.count{a,b -> a>b}
}

fun _3sumList(input: List<Int>): List<Int>{
    val sumList = mutableListOf<Int> ()
    var sum = 0
    var last = 0
    for ((index, value) in input.withIndex()) {
        if(index<2){
            sum+=value
        }
        else{
            sum+=value-last
            sumList.add(sum)
            last = input[index-2]
        }
    }
    return sumList
}
fun part2(input: List<Int>):Int{
    val sumList = _3sumList(input)
    println("sumList = $sumList")
    return part1(sumList)
}

fun main(args: Array<String>) {
    val path = "src/inputFiles/d1.txt"
    val input = readFileIntLns(path)
    val ans1 = part1(input)
    val ans2 = part2(input)
    println("Part 1 = $ans1")
    println("Part 2 = $ans2")
}

import Days.readFileLines
import java.io.File
import kotlin.math.max

fun solve(input:List<String>): List<Int> {
    val ans = mutableListOf<Int>()
    var current = 0
    for (it in input){
        if (it.isEmpty()){
            ans.add(current)
            current = 0
        }
        else{
            current += it.toInt()
        }
    }
    ans.sortDescending()
    return ans
}

fun main() {
    val input = readFileLines("_2022/src/inputFiles/Day1")
    println(solve(input)[0])
    println(solve(input).take(3).sum())
}


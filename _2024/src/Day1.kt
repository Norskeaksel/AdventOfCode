import days.readFileLines
import kotlin.math.abs


fun day1a(input: List<String>): Int {
    val a = mutableListOf<Int>()
    val b = mutableListOf<Int>()
    input.forEach { line ->
        val nums = line.split("   ")
        a.add(nums.first().toInt())
        b.add(nums.last().toInt())
    }
    a.sort()
    b.sort()
    val c = mutableListOf<Int>()
    for(i in 0 until a.size){
        c.add(abs(a[i] - b[i]))
    }
    return c.sum()
}

fun day1b(input: List<String>): Int {
    val a = mutableListOf<Int>()
    val b = mutableListOf<Int>()
    val b_count = mutableMapOf<Int,Int>(0 to 0)
    input.forEach { line ->
        val nums = line.split("   ")
        a.add(nums.first().toInt())
        b.add(nums.last().toInt())
        b_count[b.last()] = (b_count[b.last()] ?: 0) + 1
    }
    var ans = 0
    for (i in a){
        if(b_count.contains(i))
        ans += i * b_count[i]!!
    }
    return ans
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day1")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day1a(input))
    println(day1b(input))
}
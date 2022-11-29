package Days

import kotlin.math.max

fun getId(line:String): Int {
    return line.replace("B", "1").replace("F", "0")
            .replace("R", "1").replace("L", "0")
            .toInt(2)
}

fun solve1(input: List<String>): Int {
    var ans = 0
    input.forEach {
        val id = getId(it)
        ans = max(ans,id)
    }
    return ans
}

fun solve2(input: List<String>): Int {
    val nums = mutableListOf<Int>()
    input.forEach{
        nums.add(getId(it))
    }
    nums.sort()
    for(i in 1 until nums.size){
        if(nums[i]-nums[i-1]>1) return nums[i]-1
    }
    return -1
}

fun main() {
    val input = readFileLines("_2020/src/inputFiles/Day5")
    println(solve1(input))
    println(solve2(input))
}

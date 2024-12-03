package days


fun day3a(input: List<String>): Int {
    var ans = 0
    val acceptableInput = mutableSetOf<String>()
    for (i in 0 until 1000) {
        for (j in 0 until 1000) {
            acceptableInput.add("mul($i,$j)")
        }
    }
    input.forEach { line ->
        for (ai in acceptableInput) {
            if(ai in line){
                val (a, b) = ai.split(",")
                val add = 1 * a.filter { it.isDigit() }.toInt() * b.filter { it.isDigit() }.toInt()
                ans += add
                /*println("$a,$b")
                println("add: $add")
                println("ans=$ans")*/
            }
        }
    }
    return ans
}

fun day3b(input: List<String>): Int {
    input.forEach { line ->

    }
    return 0
}

fun main() {
    val input = readFileLines("_2024/inputFiles/day3")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day3a(input))
    println(day3b(input))
}
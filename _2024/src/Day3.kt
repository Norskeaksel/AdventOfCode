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
            if (ai in line) {
                val (a, b) = ai.split(",")
                val add = a.filter { it.isDigit() }.toInt() * b.filter { it.isDigit() }.toInt()
                ans += add
            }
        }
    }
    return ans
}

fun day3b(input: List<String>): Int {
    val input2 = mutableListOf<String>()
    input.forEach { line ->
        print(line)
        var newline = line
        var dontPosition = line.indexOf("don't()")
        while (dontPosition > -1) {
            var doPosition = newline.indexOf("do()")
            if(doPosition in 0..<dontPosition){
                println("Remove $doPosition to ${doPosition + 4}")
                newline = newline.removeRange(doPosition, doPosition + 4)
                dontPosition = newline.indexOf("don't()")
                continue
            }

            if(doPosition < 0 )
                doPosition = newline.length
            println("Remove $dontPosition to $doPosition")
            newline = newline.removeRange(dontPosition, doPosition)
            dontPosition = newline.indexOf("don't()")
        }
        println("adding $newline")
        input2.add(newline)
    }
    input2.forEach { println(it) }
    return day3a(input2)
}
fun main() {
    val input = readFileLines("_2024/inputFiles/day3")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day3a(input))
    println(day3b(input))
}
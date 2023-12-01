package days

fun firstLastDigits(input: List<String>): Int {
    val nums = input.map { line -> line.filter { c -> c.isDigit() } }
    return nums.fold(0) { sum, it -> sum + ("${it.first()}${it.last()}").toInt() }
}

fun firstLastDigits2(input: List<String>): Int {
    val newInput = input.map { searchReplace(it) }
    return firstLastDigits(newInput)
}

fun searchReplace(string: String): String {
    val search = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    val replace = listOf("o1e", "t2o", "t3e", "f4r", "f5e", "s6x", "s7n", "e8t", "n9e")
    var newString = string
    for (i in 0..8){
        newString = newString.replace(search[i], replace[i])
    }
    return newString
}

fun main() {
    val input = readFileLines("_2023/inputFiles/Day1")
    println(firstLastDigits(input))
    println(firstLastDigits2(input))
}


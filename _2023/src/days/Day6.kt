package days

fun allAnswers(duration: Long, target: Long) = (0..duration).map{it * (duration-it)}.filter { it > target }.size

fun day6(input: List<String>): Long {
    val duration = input[0].split(":")[1].trim().split("\\s+".toRegex()).map { it.toLong() }
    val target = input[1].split(":")[1].trim().split("\\s+".toRegex()).map { it.toLong() }
    var sum = 1L
    for(i in duration.indices){
        sum *= allAnswers(duration[i], target[i])
    }
    return sum
}

fun day62(input: List<String>): Long {
    val duration = input[0].split(":")[1].replace(" ","").split("\\s+".toRegex()).map { it.toLong() }
    val target = input[1].split(":")[1].replace(" ","").split("\\s+".toRegex()).map { it.toLong() }
    var sum = 1L
    for(i in duration.indices){
        sum *= allAnswers(duration[i], target[i])
    }
    return sum
}

fun main() {
    val input = readFileLines("_2023/inputFiles/Day6")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day6(input))
    println(day62(input))
}
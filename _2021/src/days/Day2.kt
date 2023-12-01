package days/*fun part1(){
    var depth = 0
    var distance = 0
}*/

fun calculateDepth1(input: List<String>): Int {
    var depth = 0
    var distance = 0
    for (line in input) {
        val words = line.split(" ")
        val direction = words[0]
        val movement = words[1].toInt()
        when (direction) {
            "forward" -> distance += movement
            "up" -> depth -= movement
            "down" -> depth += movement
        }
    }
    return depth * distance
}

fun calculateDepth2(input: List<String>): Int {
    var depth = 0
    var distance = 0
    var aim = 0
    for (line in input) {
        val words = line.split(" ")
        val direction = words[0]
        val movement = words[1].toInt()
        when (direction) {
            "forward" -> {
                distance += movement
                depth += aim * movement
            }

            "up" -> aim -= movement
            "down" -> aim += movement
        }
    }
    return depth * distance
}


fun main(args: Array<String>) {
    val path = "_2021/src/inputFiles/day2.txt"
    val input = readFileLines(path)
    val ans1 = calculateDepth1(input)
    println("Part 1 = $ans1")
    val ans2 = calculateDepth2(input)
    println("Part 2 = $ans2")
}

fun test(ans: Any, expected: Any) {
    if (ans != expected) {
        throw Exception("ans: $ans, Expected: $expected")
    }
}

data class Directory(val name: String) {
    val files = mutableListOf<Int>()
    val subDirectories = mutableSetOf<Directory>()
    val size = 0
}

fun simulateFileCreation(input: List<String>):Int {
    var ans = 0
    val fileSystem = Directory("home")
    var currentDir = "home"
    val dirMap = mutableMapOf<String, Int>()
    input.forEach {
        val commands = it.split(" ")
        if (commands[0] == "dir") {
            val newDir = Directory(commands[1])
            fileSystem.subDirectories.add(newDir)
        }
        if (commands[0].toIntOrNull() != null) {
            fileSystem.files.add(commands[0].toInt())
            dirMap[currentDir] = dirMap.getValue(currentDir) + commands[0].toInt()
            }
            if (commands[1] == "cd") {
                currentDir = fileSystem.subDirectories.first { it.name == commands[1] }.name
                currentDir = commands[2]
            }
        }
    for((key, value) in dirMap) {
        if (value <=100000) {
            ans += value
        }
    }
    return ans
}

fun solve2(input: List<String>): Int {
    var ans = 0
    return ans
}

fun main() {
    val inputTest = readFileLines("src/main/kotlin/TestDay")
    test(simulateFileCreation(inputTest), 95437)
    test(solve2(inputTest), 0)

    val input = readFileLines("src/main/kotlin/RealDay")
    println("Part 1: ${simulateFileCreation(input)}")
    println("Part 2: ${solve2(input)}")
}

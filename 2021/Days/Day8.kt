fun part1(input: List<String>): Int {
    return 1
}


fun part2(input: List<String>): Int {
    return -1
}


fun main(args: Array<String>) {
    val path = "src/inputFiles/day8.txt"
    val input = readFileLns(path)
    val ans1 = part1(input)
    println("Part 1 = $ans1")
    val ans2 = part2(input)
    println("Part 2 = $ans2")
}


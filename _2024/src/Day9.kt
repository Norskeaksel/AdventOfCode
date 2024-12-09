package days

fun day9a(input: String): Long {
    val diskMap = makeDiskMap(input)
    println(diskMap)
    var lastIndex = lastDigitIndex(diskMap)
    var firstIndex = diskMap.indexOf(-1)
    while (lastIndex > firstIndex) {
        diskMap[firstIndex] = diskMap[lastIndex].also { diskMap[lastIndex] = diskMap[firstIndex] }
        lastIndex = lastDigitIndex(diskMap)
        firstIndex = diskMap.indexOf(-1)
    }
    val finalDiskMap = diskMap.filter { it != -1 }
    println(finalDiskMap)
    return checksum(finalDiskMap)
}

private fun makeDiskMap(input: String): MutableList<Int> {
    val diskMap = mutableListOf<Int>()
    var id = 0
    input.forEachIndexed { i, c ->
        if (i % 2 == 0) {
            repeat(c - '0') {
                diskMap.add(id)
            }
            id++
        } else {
            repeat(c - '0') {
                diskMap.add(-1)
            }
        }
    }
    return diskMap
}

fun lastDigitIndex(diskMap: List<Int>): Int {
    for (i in diskMap.lastIndex downTo 0) {
        if (diskMap[i] != -1)
            return i
    }
    return -1
}

fun checksum(diskMap: List<Int>): Long {
    var ans = 0L
    diskMap.forEachIndexed { id, nr ->
        ans += id * nr
    }
    return ans
}

fun day9b(input: String): Int {
    val diskMap = makeDiskMap(input)
    return 0
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day9").first()
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day9a(input))
    println(day9b(input))
}
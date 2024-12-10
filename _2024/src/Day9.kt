package days

fun day9a(input: String): Long {
    val diskMap = makeIntDiskMap(input)
    println(diskMap)
    swapLastDigitWithFirstGap(diskMap)
    val finalDiskMap = diskMap.filter { it != -1 }
    println(finalDiskMap)
    return checksum(finalDiskMap)
}

private fun swapLastDigitWithFirstGap(diskMap: MutableList<Int>) {
    var lastIndex = lastDigitIndex(diskMap)
    var firstIndex = diskMap.indexOf(-1)
    while (lastIndex > firstIndex) {
        diskMap[firstIndex] = diskMap[lastIndex].also { diskMap[lastIndex] = diskMap[firstIndex] }
        lastIndex = lastDigitIndex(diskMap)
        firstIndex = diskMap.indexOf(-1)
    }
}

private fun makeIntDiskMap(input: String): MutableList<Int> {
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

private fun makeTrueDiskMap(input: String): MutableList<Pair<Int, Int>> {
    val diskMap = mutableListOf<Pair<Int, Int>>()
    var id = 0
    input.forEachIndexed { i, c ->
        if (i % 2 == 0) {
            diskMap.add(id to c - '0')
            id++
        } else {
            diskMap.add(-1 to c - '0')

        }
    }
    return diskMap
}

private fun makeStringDiskMap(input: String): List<String> {
    val diskMap = mutableListOf<String>()
    var id = 0
    input.forEachIndexed { i, c ->
        if (i % 2 == 0) {
            repeat(c - '0') {
                diskMap.add(id.toString())
            }
            id++
        } else {
            diskMap.add(".".repeat(c - '0'))
        }
    }
    val diskMapString = diskMap.joinToString("")
    val trueDiskMap = mutableListOf<String>()
    var str = diskMapString[0].toString()
    for (i in 1 until diskMapString.length) {
        if (diskMapString[i] == diskMapString[i - 1])
            str += diskMapString[i]
        else {
            trueDiskMap.add(str)
            str = diskMapString[i].toString()
        }
    }
    trueDiskMap.add(str)
    return trueDiskMap
}

fun lastDigitIndex(diskMap: List<Int>): Int {
    for (i in diskMap.lastIndex downTo 0) {
        if (diskMap[i] != -1)
            return i
    }
    return -1
}

fun spaceRange(diskMap: List<String>, neededSpace: Int): IntRange? =
    diskMap.joinToString("").indexOf(".".repeat(neededSpace)).let { if (it > -1) it until it + neededSpace else null }

fun swapNumber(diskMap: List<String>, nrIndex: Int) {

}

fun checksum(diskMap: List<Int>): Long {
    var ans = 0L
    diskMap.forEachIndexed { id, nr ->
        ans += id * nr
    }
    return ans
}

fun day9b(input: String): Long {
    val originalDiskMap = makeTrueDiskMap(input)
    println(originalDiskMap)
    val diskMap = originalDiskMap.toMutableList()
    for (i in diskMap.indices.reversed()) {
        if (i % 1000 == 0) {
            println(i)
        }
        if (diskMap[i].first == -1)
            continue
        val neededSpace = diskMap[i].second
        val spaceLocation = diskMap.indexOfFirst { it.first == -1 && it.second <= neededSpace }
        if (spaceLocation == -1 || spaceLocation >= i)
            continue
        val leftOverSpace = diskMap[spaceLocation].second - neededSpace
        diskMap[spaceLocation] = diskMap[i]
        diskMap[i] = -1 to neededSpace
        if (leftOverSpace > 0)
            diskMap.add(spaceLocation + 1, -1 to leftOverSpace)
    }
    println(diskMap)
    //val finalDiskMap = .map { if (it == '.') 0 else it.digitToInt() }*/
    return 0//checksum(finalDiskMap)
}

fun diskMap2String(diskMap: List<Pair<Int,Int>>){
    var s = ""
    diskMap.forEach {
        repeat(it.second){
            //s+=it.first -
        }
    }
}
/*val firstEndIndex = originalDiskMap.lastIndex
var currentId = originalDiskMap[firstEndIndex]
var i = firstEndIndex
var endRange = originalDiskMap.lastIndex
var startRange = firstEndIndex
while (i > 0) {
    if (originalDiskMap[i] == ".") {
        i--
        continue
    }
    if (currentId == ".")
        currentId = originalDiskMap[i]
    if (originalDiskMap[i] == currentId) {
        startRange = i--
    } else {
        val neededSpace = endRange - startRange + 1
        val spaceRange = spaceRange(diskMap, neededSpace)
        if (spaceRange == null) {
            i--
            currentId = "."
            continue
        }
        for (c in spaceRange) {
            diskMap[c] = currentId
        }
        for (c in startRange..endRange) {
            diskMap[c] = "."
        }
        currentId = originalDiskMap[i]
        endRange = i
        startRange = i
        i--
        println(diskMap)
    }
}
println(diskMap)
val filteredDiskMap: List<Int> = diskMap.filter { it != "." }.map { it.toInt() }
return checksum(filteredDiskMap)
}*/

fun main() {
    val input = readFileLines("_2024/inputFiles/Day9").first()
    require(input.isNotEmpty()) { "Input file must not be empty" }
    // println(day9a(input))
    println(day9b(input))
}
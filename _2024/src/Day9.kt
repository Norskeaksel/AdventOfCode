package days

import java.math.BigInteger

fun day9a(input: String): Long {
    val diskMap = makeIntDiskMap(input)
    //println(diskMap)
    swapLastDigitWithFirstGap(diskMap)
    val finalDiskMap = diskMap.filter { it != -1 }
    //println(finalDiskMap)
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

fun lastDigitIndex(diskMap: List<Int>): Int {
    for (i in diskMap.lastIndex downTo 0) {
        if (diskMap[i] != -1)
            return i
    }
    return -1
}

fun gapRange(diskMap: List<Int>, neededSpace: Int): IntRange? {
    var gapCount = 0
    for (i in diskMap.indices) {
        if (diskMap[i] != -1)
            gapCount = 0
        else {
            gapCount++
            if (gapCount == neededSpace)
                return i - neededSpace + 1..i
        }
    }
    return null
}

fun idRange(diskMap: List<Int>, endIndex: Int): IntRange? {
    if (diskMap[endIndex] == -1)
        return null
    val id = diskMap[endIndex]
    var rangeStart = endIndex
    for (i in endIndex - 1 downTo 0) {
        if (diskMap[i] == id)
            rangeStart--
        else {
            return rangeStart..endIndex
        }
    }
    return null
}

fun checksum(diskMap: List<Int>): Long {
    var ans = 0L
    diskMap.forEachIndexed { id, nr ->
        ans += id * nr
    }
    return ans
}

fun bigChecksum(diskMap: List<Int>): BigInteger {
    var ans = BigInteger.ZERO
    diskMap.forEachIndexed { id, nr ->
        ans = ans.plus(BigInteger.valueOf((id * nr).toLong()))
    }
    return ans
}

fun day9b(input: String): Long {
    val originalDiskMap = makeIntDiskMap(input)
    //println(originalDiskMap)
    val diskMap = originalDiskMap.toMutableList()
    var i = diskMap.size
    while (i-- > 0) {
        val fileRange = idRange(diskMap, i) ?: continue
        val fileSize = fileRange.count()
        val gapRange = gapRange(diskMap, fileRange.count())
        if (gapRange == null || gapRange.last >= fileRange.first) {
            i -= fileSize-1
            continue
        }
        for (j in gapRange) {
            diskMap[j] = diskMap[i]
        }
        for (j in fileRange) {
            diskMap[j] = -1
        }
        i -= fileSize - 1
        //System.err.println(diskMap)
    }
    //println(diskMap)
    val finalDiskMap = diskMap.map { if (it == -1) 0 else it }
    //println(finalDiskMap)
    return checksum(finalDiskMap)
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day9").first()
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day9a(input))
    println(day9b(input))
}
package days

import java.io.File
import java.io.InputStream

fun test(ans: Any, expected: Any) {
    if (ans != expected) {
        throw Exception("ans: $ans, Expected: $expected")
    }
}

fun Boolean.toInt() = if (this) 1 else 0
fun readString() = readLine()!!
fun readStrings() = readString().split(" ")
fun readInt() = readString().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readString().toLong()
fun readLongs() = readStrings().map { it.toLong() }
fun readDouble() = readString().toDouble()
fun readDoubles() = readStrings().map { it.toDouble() }

fun readFileLines(fileName:String) = File(fileName).readLines()

fun readFile(fileName: String): String = readFileLines(fileName).joinToString("\n")

fun readFileIntLines(fileName:String) = readFileLines(fileName).map{it.toInt()}
fun readLineByLine(fileName: String): List<String>{
    val inputStream: InputStream = File(fileName).inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().forEachLine { lineList.add(it) }
    return lineList
}
fun readGrid(fileName: String): MutableList<MutableList<Int>>{
    val input = readFileLines(fileName)
    val grid = mutableListOf<MutableList<Int>>()
    input.forEach { grid.add(it.map { it.digitToInt() }.toMutableList()) }
    return grid
}

fun copy2Dlist(input: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    val copy = mutableListOf<MutableList<Int>>()
    input.forEach { copy.add(it.toMutableList()) }
    return copy
}


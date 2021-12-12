import java.io.File
import java.io.InputStream

fun readLn() = readLine()!!
fun readInt() = readLn().toInt()
fun readStrings() = readLn().split(' ')
fun readInts() = readStrings().map { it.toInt() }
fun readFileLns(fileName:String) = File(fileName).readLines()
fun readFileIntLns(fileName:String) = readFileLns(fileName).map{it.toInt()}
fun readLineByLine(fileName: String): List<String>{
    val inputStream: InputStream = File(fileName).inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().forEachLine { lineList.add(it) }
    return lineList
}
fun readGrid(fileName: String): MutableList<MutableList<Int>>{
    val input = readFileLns(fileName)
    val grid = mutableListOf<MutableList<Int>>()
    input.forEach { grid.add(it.map { it.digitToInt() }.toMutableList()) }
    return grid
}

fun copy2Dlist(input: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    val copy = mutableListOf<MutableList<Int>>()
    input.forEach { copy.add(it.toMutableList()) }
    return copy
}

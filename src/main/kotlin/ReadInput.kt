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

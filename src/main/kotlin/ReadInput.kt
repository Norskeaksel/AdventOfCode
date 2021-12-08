import java.io.File

fun readLn() = readLine()!!
fun readInt() = readLn().toInt()
fun readStrings() = readLn().split(' ')
fun readInts() = readStrings().map { it.toInt() }
fun readFileLns(fileName:String) = File(fileName).readLines()
fun readFileIntLns(fileName:String) = readFileLns(fileName).map{it.toInt()}

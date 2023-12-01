import java.io.File

fun first4UniqueChar(input: String): Int {
    for(i in 13 until input.length){
        val last4Char = input.substring(i-13,i+1)
        if (last4Char.length == last4Char.toSet().size){
            return i+1
        }
    }
    return 0
}

fun main() {
    val input = File("_2022/src/inputFiles/Day6").readText()
    println(first4UniqueChar(input))
}

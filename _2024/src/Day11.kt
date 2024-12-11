import days.readFileLines
import java.math.BigInteger

fun day11a(input: String): Int {
    var numbers = input.split(" ").map { BigInteger.valueOf(it.toLong()) }
    repeat(75){
        println(it)
        val newList = mutableListOf<BigInteger>()
        numbers.forEach {
            val asString = it.toString()
            val digitCount = asString.length
            if(it == BigInteger.ZERO)
                newList.add(BigInteger.ONE)
            else if(digitCount%2 == 0){
                val a = asString.substring(0 until digitCount / 2)
                val b = asString.substring( digitCount / 2 until digitCount)
                newList.add(a.toBigInteger())
                newList.add(b.toBigInteger())
            }
            else {
                newList.add(it.multiply(2024.toBigInteger()))
            }
        }
        numbers = newList
    }
    return numbers.size
}

fun day11b(input: String): Int {
    return 0
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day11").first()
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day11a(input))
    // println(day11b(input))
}


import days.readFileLines
import java.math.BigInteger

fun day11a(input: String): Int {
    var numbers = input.split(" ").map { it.toLong() }
    repeat(25) {
        println("$it: ${numbers.size}")
        val newList = mutableListOf<Long>()
        numbers.forEach {
            val asString = it.toString()
            val digitCount = asString.length
            if (it == 0L)
                newList.add(1)
            else if (digitCount % 2 == 0) {
                val a = asString.substring(0 until digitCount / 2).toLong()
                val b = asString.substring(digitCount / 2 until digitCount).toLong()
                newList.add(a)
                newList.add(b)
            } else {
                newList.add(it * 2024L)
            }
        }
        numbers = newList
    }
    return numbers.size
}

fun MutableCollection<Long>.sumToBigInteger(): BigInteger =
    fold(BigInteger.ZERO) { acc, long -> acc + BigInteger.valueOf(long) }

fun day11b(input: String): BigInteger {
    val numbers = input.split(" ").map { it.toLong() }
    val numberCount = numbers.associateBy({ it }, { 1L }).toMutableMap().withDefault { 0L }
    repeat(75) {c ->
        println("$c: ${numberCount.values.sumToBigInteger()}")
        numberCount.toMap().forEach {
            val asString = it.key.toString()
            val digitCount = asString.length
            if (it.key == 0L) {
                numberCount[1] = numberCount.getValue(1L) + it.value
                numberCount[0] = numberCount[0]!! - it.value
            } else if (digitCount % 2 == 0) {
                val a = asString.substring(0 until digitCount / 2).toLong()
                val b = asString.substring(digitCount / 2 until digitCount).toLong()
                numberCount[a] = numberCount.getValue(a) + it.value
                numberCount[b] = numberCount.getValue(b) + it.value
                numberCount[it.key] = numberCount[it.key]!! - it.value
            } else {
                numberCount[it.key * 2024] = numberCount.getValue(it.key * 2024) + it.value
                numberCount[it.key] = numberCount[it.key]!! - it.value
            }
        }
    }
    return numberCount.values.sumToBigInteger()
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day11").first()
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day11a(input))
    println(day11b(input))
}


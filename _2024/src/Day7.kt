package days

import java.lang.Math.pow

fun day7a(input: List<String>): Long {
    var puzzleAnswer = 0L
    input.forEach { line ->
        val (answerStr, numbers) = line.split(": ")
        val answer = answerStr.toLong()
        println("answer=$answer, numbers=$numbers")
        val numberList = numbers.split(" ").map { it.toLong() }
        println("numberList=$numberList")
        val nrOfOperators = numberList.size - 1
        repeat(pow(2.0, nrOfOperators.toDouble()).toInt()) {
            val binaryNumber = it.toString(2)
            val binaryNumberPadded = binaryNumber.padStart(nrOfOperators, '0')
            // println(binaryNumberPadded)
            var tempAns = numberList[0]
            binaryNumberPadded.forEachIndexed { idx, digit ->
                if (digit == '0')
                    tempAns += numberList[idx + 1]
                else {
                    tempAns *= numberList[idx + 1]
                }
            }
            if (tempAns == answer) {
                println("Adding $answer")
                puzzleAnswer += answer
                return@forEach
            }
        }
    }
    return puzzleAnswer
}

fun day7b(input: List<String>): Long {
    var puzzleAnswer = 0L
    input.forEach { line ->
        val (answerStr, numbers) = line.split(": ")
        val answer = answerStr.toLong()
        println("answer=$answer, numbers=$numbers")
        val numberList = numbers.split(" ").map { it.toLong() }
        println("numberList=$numberList")
        val nrOfOperators = numberList.size - 1
        repeat(pow(3.0, nrOfOperators.toDouble()).toInt()) {
            val trinaryNumber = it.toString(3)
            val trinaryNumberPadded = trinaryNumber.padStart(nrOfOperators, '0')
            // println(trinaryNumberPadded)
            var tempAns = numberList[0]
            trinaryNumberPadded.forEachIndexed { idx, digit ->
                if (digit == '0')
                    tempAns += numberList[idx + 1]
                else if(digit == '1')
                    tempAns *= numberList[idx + 1]
                else {
                    tempAns = (tempAns.toString() + numberList[idx + 1].toString()).toLong()
                }
            }
            if (tempAns == answer) {
                println("Adding $answer")
                puzzleAnswer += answer
                return@forEach
            }
        }
    }
    return puzzleAnswer
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day7")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day7a(input))
    println(day7b(input))
}
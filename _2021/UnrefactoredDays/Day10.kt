package Days

import java.util.ArrayDeque

fun part1(input: List<String>): Int {
    val charToPoints = mapOf(')' to 3, ']' to 57, '}' to 1197, '>' to 25137)
    var score = 0
    for (str in input) {
        val s = ArrayDeque<Char>()
        for (i in 0 until str.length) {
            val c = str[i];
            if (c == '(' || c == '{' || c == '[' || c == '<')
                s.push(c);

            if (c == ')' || c == '}' || c == ']' || c == '>') {
                val r = s.pop();
                if (c == ')' && r != '(' || c == '}' && r != '{' || c == ']' && r != '[' || c == '>' && r != '<') {
                    //println("${str[i]} $i")
                    score += charToPoints[c]!!
                    break
                }
            }
        }
    }
    return score
}

fun part2(input: List<String>): Long {
    val charToPoints = mapOf('(' to 1, '[' to 2, '{' to 3, '<' to 4)
    var results = mutableListOf<Long>()
    for (str in input) {
        var score = 0L
        val possiblieCoruption = listOf<String>(str)
        if (part1(possiblieCoruption) > 0) {
            continue
        }
        val s = ArrayDeque<Char>()
        for (i in 0 until str.length) {
            val c = str[i];
            if (c == '(' || c == '{' || c == '[' || c == '<')
                s.push(c);

            if (c == ')' || c == '}' || c == ']' || c == '>')
                s.pop();
    }
        while (!s.isEmpty()){
            val r=s.pop()
            score*=5
            score+= charToPoints[r]!!
        }
        results.add(score)
    }
    val sortedResults = results.sorted()
    return sortedResults[results.size / 2]
}

fun main(args: Array<String>) {
    val path = "src/inputFiles/day10.txt"
    val input = readLineByLine(path)
    val ans1 = part1(input)
    println("Part 1 = $ans1")
    val ans2 = part2(input)
    println("Part 2 = $ans2")
}

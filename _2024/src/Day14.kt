package days

import java.io.File
import java.io.OutputStream
import java.io.PrintWriter

@JvmField
val OUTPUT: OutputStream = "_2024/src/Day14EasterEgg.txt".let { path ->
    if (File(path).exists())
        File(path).outputStream()
    else
        System.out
}

@JvmField
val _writer = PrintWriter(OUTPUT, false)

data class Point(var x: Int, var y: Int, val dx:Int?=null, val dy:Int?=null)

fun day14a(input: List<String>, with:Int = 101, height:Int = 103): Long {
    val robots = mutableListOf<Point>()
    input.forEach { line ->
        val regex = "p=(\\d+),(-?\\d+) v=(-?\\d+),(-?\\d+)".toRegex()
        val matchResult = regex.matchEntire(line)!!
        val (x, y, dx, dy) = matchResult.destructured.toList().map { it.toInt() }
        val nx = (x + 100 * dx)
        val ny = (y + 100 * dy)
        val fx = (nx % with).let { if(it < 0) it+with else it }
        val fy = (ny % height).let { if(it < 0) it+height else it }
        robots.add(Point(fx, fy))
    }
    val filteredRobots = robots.filter { it.x != with/2 && it.y != height/2 }
    val q = LongArray(4)
    filteredRobots.forEach { p ->
        val qp = findQuadrant(p, with, height) ?: return@forEach
        q[qp]++
    }
    return q.reduce { acc, num -> acc * num }
}

fun findQuadrant(p: Point, w: Int, h: Int): Int {
    val (x, y) = p
    return when {
        x < w/2 && y > h/2 -> 1
        x >= w/2 && y > h/2 -> 0
        x < w/2 && y < h/2 -> 2
        else -> 3
    }
}

fun day14b(input: List<String>, with:Int = 101, height:Int = 103): Long {
    val robots = mutableListOf<Point>()
    input.forEach { line ->
        val regex = "p=(\\d+),(-?\\d+) v=(-?\\d+),(-?\\d+)".toRegex()
        val matchResult = regex.matchEntire(line)!!
        val (x, y, dx, dy) = matchResult.destructured.toList().map { it.toInt() }
        robots.add(Point(x,y, dx, dy))
    }
    repeat(10_001){
        val grid = mutableListOf<MutableList<Char>>()
        repeat(height){
            val line = mutableListOf<Char>()
            repeat(with) {
                line.add('.')
            }
            grid.add(line)
        }
        robots.forEach {
            val (x,y) = it
            grid[y][x] = 'X'
        }

        _writer.print("$it:\n")
        grid.forEach { line ->
            line.forEach { char ->
                _writer.print(char)
            }
            _writer.println()
        }
        robots.forEach { p ->
            p.x = (p.x + p.dx!!).let { if(it < 0) it + with else it % with}
            p.y = (p.y + p.dy!!).let { if(it < 0) it + height else it % height}
        }
    }
    val filteredRobots = robots.filter { it.x != with/2 && it.y != height/2 }
    val q = LongArray(4)
    filteredRobots.forEach { p ->
        val qp = findQuadrant(p, with, height) ?: return@forEach
        q[qp]++
    }
    return q.reduce { acc, num -> acc * num }
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day14")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day14a(input))
    println(day14b(input))
}
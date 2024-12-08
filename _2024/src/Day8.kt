import days.readFileLines

data class Point(val x: Int, val y: Int)

fun day8a(input: List<String>): Int {
    val grid = mutableListOf<String>()
    val points = mutableListOf<Point>()
    val with = input[0].length
    val height = input.size
    input.forEachIndexed { y, line ->
        grid.add(line)
        for (x in 0 until with) {
            points.add(Point(x, y))
        }
    }
    val antinodes = mutableSetOf<Point>()
    for (p1 in points) {
        val point2StartIndex = points.indexOf(p1)
        val c1 = grid[p1.y][p1.x]
        if (c1 == '.')
            continue
        for (point2Index in point2StartIndex + 1 until points.size) {
            val p2 = points[point2Index]
            val c2 = grid[p2.y][p2.x]
            if (c2 == c1) {
                val dx = p2.x - p1.x
                val dy = p2.y - p1.y
                antinodes.add(Point(p2.x + dx, p2.y + dy))
                antinodes.add(Point(p1.x - dx, p1.y - dy))
            }
        }
    }
    antinodes.forEach { println(it) }
    return antinodes.filter { it.x in 0 until with && it.y in 0 until height }.size
}


fun day8b(input: List<String>): Int {
    val grid = mutableListOf<String>()
    val points = mutableListOf<Point>()
    val with = input[0].length
    val height = input.size
    input.forEachIndexed { y, line ->
        grid.add(line)
        for (x in 0 until with) {
            points.add(Point(x, y))
        }
    }
    val antinodes = mutableSetOf<Point>()
    for (p1 in points) {
        val point2StartIndex = points.indexOf(p1)
        val c1 = grid[p1.y][p1.x]
        if (c1 == '.')
            continue
        for (point2Index in point2StartIndex + 1 until points.size) {
            val p2 = points[point2Index]
            val c2 = grid[p2.y][p2.x]
            if (c2 == c1) {
                val dx = p2.x - p1.x
                val dy = p2.y - p1.y
                repeat(100) {
                    antinodes.add(Point(p2.x + dx*it, p2.y + dy*it))
                    antinodes.add(Point(p1.x - dx*it, p1.y - dy*it))
                }
            }
        }
    }
    return antinodes.filter { it.x in 0 until with && it.y in 0 until height }.size
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day8")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day8a(input))
    println(day8b(input))
}
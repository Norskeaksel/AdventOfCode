import days.readFileLines
import graphClasses.Grid

fun day18a(input: List<String>, gridSize: Int, lineCount: Int): Int {
    val grid = Grid(gridSize, gridSize)
    grid.print()
    input.forEachIndexed { i, line ->
        if (i >= lineCount)
            return@forEachIndexed

        val (x, y) = line.split(",").map { it.toInt() }
        val corruptId = grid.xy2Id(x, y)!!
        grid.nodes[corruptId] = null
    }
    grid.connectGrid(grid::getStraightNeighbours)
    val bfs = BFS(grid.getAdjacencyList())
    bfs.bfsIterative(listOf(0))
    val ans = bfs.distances[grid.xy2Id(gridSize - 1, gridSize - 1)!!].toInt()
    return ans
}

fun day18b(input: List<String>, gridSize: Int): String {
    var c = 0
    input.forEach { line ->
        val (x, y) = line.split(",").map { it.toInt() }
        val dist = day18a(input, gridSize, ++c)
        if (dist == -1)
            return "$x,$y"
    }
    return ""
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day18")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day18a(input, 71, 1024))
    println(day18b(input, 71))
}
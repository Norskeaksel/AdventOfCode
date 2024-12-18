import days.readFileLines

fun day18a(input: List<String>): Int {
    val grid = Grid(7, 7)
    grid.connectGrid(grid::getStraightNeighbours)
    val corruptNodes = mutableListOf<Grid.Tile>()
    input.forEach { line ->
        val (x, y) = line.split(",").map { it.toInt() }
        corruptNodes.add(grid.xy2Node(x, y)!!)
    }
    for (i in 0 until 1024) {
        if (i >= corruptNodes.size)
            break
        val u = corruptNodes[i]
        val neighbours = grid.getStraightNeighbours(u)
        neighbours.forEach { v ->
            // grid.removeEdge(v, u)
        }
    }
    println(grid.getAdjacencyList())
    val bfs = BFS(grid.getAdjacencyList())
    bfs.bfsIterative(listOf(0))
    return bfs.distances[grid.xy2Id(grid.width-1, grid.height-1)!!].toInt()
}

fun day18b(input: List<String>): Int {
    var ans = 0
    input.forEach { line ->
    }
    return ans
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day18")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day18a(input))
    println(day18b(input))
}
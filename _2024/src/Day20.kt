import days.readFileLines
import graphClasses.Dijkstra
import graphClasses.Grid
import graphClasses.Tile
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.abs

fun day20a(input: List<String>, cheatGoal: Int, fairTime: Int): Int {
    val shadowGrid = input.map { it + it }
    val grid = Grid(shadowGrid)
    grid.print()

    fun getShadowNeighbours(t: Tile) = grid.getStraightNeighbours(t).mapNotNull {
        if (it.data != '#') it
        else if (t.x < grid.width / 2) grid.xy2Node(it.x + grid.width / 2, it.y)
        else null
    }

    grid.connectGrid(::getShadowNeighbours)
    val startId = grid.nodes.indexOfFirst { it?.data == 'S' }
    val endId = grid.nodes.indexOfLast { it?.data == 'E' }

    var timeSaved = fairTime
    var c = -1
    while (timeSaved >= cheatGoal) {
        val bfs = BFS(grid)
        c++
        bfs.bfsIterative(listOf(startId))
        val cheatDist = bfs.distances[endId]
        timeSaved = (fairTime - cheatDist)
        println("timeSaved: $timeSaved")
        grid.removeCheatPath(getPath(endId, bfs.parent))
    }
    return c
}

fun day20b(input: List<String>, cheatGoal: Int, fairTime: Int): Int {
    val shadowGrid = input.map { it + it }
    val grid = Grid(shadowGrid)
    grid.print()
    fun getShadowNeighbours(t: Tile) = grid.getStraightNeighbours(t).mapNotNull {
        if (it.data != '#') it
        //else if (t.x < grid.width / 2) grid.xy2Node(it.x + grid.width / 2, it.y)
        else null
    }

    grid.connectGrid(::getShadowNeighbours)
    for (x in 0 until grid.width / 2) {
        for (y in 0 until grid.height) {
            val currentTile = grid.xy2Node(x, y) ?: continue
            for (dx in -20..20) {
                val remainingDistance = 20 - abs(dx)
                for (dy in -remainingDistance..remainingDistance) {
                    val endNode =
                        grid.xy2Node(currentTile.x + dx + grid.width / 2, currentTile.y + dy) ?: continue
                    if (endNode == currentTile)
                        continue
                    val distance = abs(dx) + abs(dy) * 1.0
                    if (endNode.data != '#' && endNode.x > grid.width / 2)
                        grid.addEdge(currentTile, endNode, distance)
                }
            }
        }
    }
    val startId = grid.nodes.indexOfFirst { it?.data == 'S' }
    val endId = grid.nodes.indexOfLast { it?.data == 'E' }


    var timeSaved = fairTime
    var c = -1
    var dijkstra: Dijkstra
    val nrOfCheets = mutableMapOf<Int, Int>()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    while (timeSaved >= cheatGoal) {
        c++
        dijkstra = Dijkstra(grid)
        dijkstra.dijkstra(startId, endId)
        val cheatDist = dijkstra.distances[endId]
        timeSaved = (fairTime - cheatDist).toInt()
        if (timeSaved >= cheatGoal)
            nrOfCheets[timeSaved] = nrOfCheets.getOrDefault(timeSaved, 0) + 1
        if (c % 1000 == 0)
            println(
                "found $c cheats so far that saves at least: $timeSaved. Current time: ${
                    LocalDateTime.now().format(formatter)
                }"
            )
        val path = getPath(endId, dijkstra.parents)
        val (p1, p2) = grid.findPortals(path)?.mapNotNull { grid.id2Node(it) } ?: break
        grid.removeEdge(p1, p2)
    }
    println(nrOfCheets)
    println("Cheets: ${nrOfCheets.values.sum()}")
    return nrOfCheets.values.sum()
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day20")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day20a(input, 100, 9412))
    println(day20b(input, 100, 9412))
}
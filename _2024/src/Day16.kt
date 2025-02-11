import days.readFileLines
import graphClasses.Dijkstra

data class Node(val x: Int, val y: Int, val c: Char, val d: Char)

fun day16a(input: List<String>): Long {
    val grid = mutableListOf<String>()
    input.forEach { line ->
        grid.add(line)
    }
    val directions = listOf('>', 'v', '<', '^')
    val directionMapping = listOf(1 to 0, 0 to 1, -1 to 0, 0 to -1) // xy mapping from directions
    val directionPairs = directions.zip(directionMapping) // direction to xy movement
    val graph = buildGraph(grid, directions)
    connectGraph(grid, directions, graph, directionPairs)
    val dijkstra = Dijkstra(graph.getAdjacencyList())
    val startNode = graph.nodes().first { (it as Node).c == 'S' && it.d == '>' }
    val endIds = graph.nodes().filter { (it as Node).c == 'E' }.map { graph.node2id(it)!! }
    dijkstra.dijkstra(graph.node2id(startNode)!!)
    var ans = Double.MAX_VALUE
    endIds.forEach {
        // println(dijkstra.distance[it])
        ans = dijkstra.distances[it].coerceAtMost(ans)
    }
    return ans.toLong()
}

private fun connectGraph(
    grid: MutableList<String>,
    directions: List<Char>,
    graph: Graph,
    directionPairs: List<Pair<Char, Pair<Int, Int>>>
) {
    for (y in 1 until grid.size - 1) {
        for (x in 1 until grid[0].length - 1) {
            val c = grid[y][x]
            for (d in directions) {
                val node = Node(x, y, c, d)
                val leftRightTurns = getLeftRightTurns(node, directions)
                for (turn in leftRightTurns) {
                    val neighbour = Node(x, y, c, turn)
                    graph.addEdge(node, neighbour, 1000.0)
                }
                val (dx, dy) = directionPairs.first { it.first == node.d }.second
                val nx = x + dx
                val ny = y + dy
                val dc = grid[ny][nx]
                if (dc != '#') {
                    val neighbour = Node(nx, ny, dc, d)
                    graph.addEdge(node, neighbour)
                }
            }
        }
    }
}

fun getNeighbours(x: Int, y: Int) = listOf(x - 1 to y, x + 1 to y, x to y - 1, x to y + 1)

fun getLeftRightTurns(node: Node, directions: List<Char>): List<Char> {
    val currentDirection = directions.indexOf(node.d)
    val nextDirectionsIndexes = (currentDirection - 1..currentDirection + 1).map { (it + 4) % 4 }
    val leftRightTurns = directions.slice(nextDirectionsIndexes)
    return leftRightTurns

}

private fun buildGraph(grid: MutableList<String>, directions: List<Char>): Graph {
    val graph = Graph()
    for (y in 0 until grid.size) {
        for (x in 0 until grid[0].length) {
            val c = grid[y][x]
            for (d in directions) {
                graph.addNode(Node(x, y, c, d))
            }
        }
    }
    return graph
}

fun day16b(input: List<String>): Int {
    val grid = mutableListOf<String>()
    input.forEach { line ->
        grid.add(line)
    }
    val directions = listOf('>', 'v', '<', '^')
    val directionMapping = listOf(1 to 0, 0 to 1, -1 to 0, 0 to -1) // xy mapping from directions
    val directionPairs = directions.zip(directionMapping) // direction to xy movement
    val graph = buildGraph(grid, directions)
    connectGraph(grid, directions, graph, directionPairs)
    val startNode = graph.nodes().first { (it as Node).c == 'S' && it.d == '>' }
    val startId = graph.node2id(startNode)!!
    val endIds = graph.nodes().filter { (it as Node).c == 'E' }.map { graph.node2id(it)!! }
    val optimalNodes = mutableSetOf<Any>()
    val optimalDistance = day16a(input).toDouble()
    var y = -1
    graph.nodes().forEach { currentNode ->
        if((currentNode as Node).y != y){
            y = currentNode.y
            println("$y/${grid.size}")
        }
        val currentId = graph.node2id(currentNode)!!
        val startToCurrent = Dijkstra(graph.getAdjacencyList())
        val currentToEnd = Dijkstra(graph.getAdjacencyList())
        startToCurrent.dijkstra(startId)
        currentToEnd.dijkstra(currentId)
        val startToCurrentDist = startToCurrent.distances[currentId]
        var currentToEndDist = Double.MAX_VALUE
        endIds.forEach { currentToEndDist = currentToEnd.distances[it].coerceAtMost(currentToEndDist) }
        if (startToCurrentDist + currentToEndDist == optimalDistance) {
            optimalNodes.add(currentNode)
        }
    }
    val optimalXYs = mutableSetOf<Pair<Int, Int>>()
    optimalNodes.forEach {
        val n = it as Node
        optimalXYs.add(n.x to n.y)
    }
    return optimalXYs.size
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day16")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    // intln(day16a(input))
    println(day16b(input))
}
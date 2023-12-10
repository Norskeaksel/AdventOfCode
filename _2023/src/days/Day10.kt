package days

import kotlin.math.abs

fun circumferenceAndArea(input: List<String>): Int {
    val g = Grid(input[0].length, input.size)
    var startTile: Grid.Tile? = null
    input.forEachIndexed { y, line ->
        line.forEachIndexed { x, c ->
            val t = Grid.Tile(x, y, c)
            if (t.data == 'S')
                startTile = t
            g.addNode(t)
        }
    }
    g.getNodes().forEach { t ->
        when (t.data) {
            'S' -> addSouthNode(g, t) // Found from analyzing input data
            '|' -> addNorthNode(g, t).also { addSouthNode(g, t) }
            '-' -> addEastNode(g, t).also { addWestNode(g, t) }
            'L' -> addNorthNode(g, t).also { addEastNode(g, t) }
            'J' -> addNorthNode(g, t).also { addWestNode(g, t) }
            '7' -> addSouthNode(g, t).also { addWestNode(g, t) }
            'F' -> addEastNode(g, t).also { addSouthNode(g, t) }
        }
    }
    val dfs = DFS2(g.getAdjacencyList(), g)
    val startId = g.xy2Id(startTile!!.x, startTile!!.y)
    dfs.dfsIterative(startId)
    println(dfs.area)
    return dfs.depth / 2
}

fun addNorthNode(g: Grid, t: Grid.Tile) {
    val northNode = g.xy2Node(t.x, t.y - 1) ?: return
    if (northNode.data in listOf('|', '7', 'F'))
        g.addEdge(t, northNode)
}

fun addWestNode(g: Grid, t: Grid.Tile) {
    val westNode = g.xy2Node(t.x - 1, t.y) ?: return
    if (westNode.data in listOf('-', 'L', 'F'))
        g.addEdge(t, westNode)
}

fun addSouthNode(g: Grid, t: Grid.Tile) {
    val southtNode = g.xy2Node(t.x, t.y + 1) ?: return
    if (southtNode.data in listOf('|', 'L', 'J'))
        g.addEdge(t, southtNode)
}

fun addEastNode(g: Grid, t: Grid.Tile) {
    val eastNode = g.xy2Node(t.x + 1, t.y) ?: return
    if (eastNode.data in listOf('-', '7', 'J'))
        g.addEdge(t, eastNode)
}

fun day102(input: List<String>): Int {
    input.forEach { line ->

    }
    return 0
}

fun main() {
    val input = readFileLines("_2023/inputFiles/day10")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(circumferenceAndArea(input))
}

class Grid(private val width: Int, val height: Int) {
    data class Tile(val x: Int, val y: Int, var data: Any? = null)

    private val size = width * height
    private val nodes = Array(size) { Tile(-1, -1) }
    private val adjacencyList = adjacencyListInit(size)

    fun xy2Id(x: Int, y: Int) = x + y * width
    fun id2Node(id: Int) = if (id in 0 until size) nodes[id] else null

    fun xy2Node(x: Int, y: Int) = id2Node(xy2Id(x, y))
    fun node2Id(t: Tile) = t.x + t.y * width
    fun getNodes(): List<Tile> = nodes.filter { it.x != -1 }
    fun getEdges(t: Tile): List<Edge> = adjacencyList[node2Id(t)]
    fun getAdjacencyList() = adjacencyList
    fun size() = nodes.count { it.x != -1 }

    fun addNode(t: Tile) {
        val id = node2Id(t)
        nodes[id] = t
    }

    fun addEdge(t1: Tile, t2: Tile, weight: Double = 1.0) {
        val u = node2Id(t1)
        val v = node2Id(t2)
        adjacencyList[u].add(Edge(weight, v))
    }

    fun connect(t1: Tile, t2: Tile, weight: Double = 1.0) {
        addEdge(t1, t2, weight)
        addEdge(t2, t1, weight)
    }

    // @formatter:off
    fun getStraightNeighbours(t: Tile) =
        listOfNotNull(
            if(t.x > 0)        xy2Node(t.x - 1, t.y) else null,
            if(t.x < width-1)  xy2Node(t.x + 1, t.y) else null,
            if(t.y > 0)        xy2Node(t.x, t.y - 1) else null,
            if(t.y < height-1) xy2Node(t.x, t.y + 1) else null
        )

    fun getDiagonalNeighbours(t: Tile) =
        listOfNotNull(
            if(t.x > 0 && t.y > 0)              xy2Node(t.x - 1, t.y - 1) else null,
            if(t.x < width-1 && t.y > 0)        xy2Node(t.x + 1, t.y - 1) else null,
            if(t.x > 0 && t.y < height-1)       xy2Node(t.x - 1, t.y + 1) else null,
            if(t.x < width-1 && t.y < height-1) xy2Node(t.x + 1, t.y + 1) else null
        )
    // @formatter:on

    fun getAllNeighbours(t: Tile) = getStraightNeighbours(t) + getDiagonalNeighbours(t)
}

typealias Edge = Pair<Double, Int>// Edge with weight w to node v
typealias Edges = MutableList<Edge>
typealias AdjacencyList = MutableList<Edges>

fun adjacencyListInit(size: Int): AdjacencyList = MutableList(size) { mutableListOf() }

class DFS2(val graph: AdjacencyList, val g: Grid) {
    val size = graph.size
    var visited = BooleanArray(size)
    var depth = 0
    var area = 0
    private var currentVisited = mutableListOf<Int>()

    fun dfsIterative(startId: Int) {
        currentVisited.clear()
        val stack = ArrayDeque<Int>()
        stack.add(startId)
        var previousId = startId
        val additions = mutableListOf<Int>()
        while (stack.isNotEmpty()) {
            val currentId = stack.last()
            stack.removeLast()
            if (visited[currentId])
                if(currentId!=startId)
                    continue

            if (previousId + 1 == currentId) {
                val node = g.id2Node(currentId)!!
                val add = g.height - node.y
                println("${node.data}  $add")
                area += add
                additions.add(add)
            }
            if (previousId - 1 == currentId) {
                val node = g.id2Node(currentId)!!
                val add = (g.height - node.y)*-1
                println("${node.data}  $add")
                area -= g.height - node.y
                additions.add(add)
            }
            previousId = currentId
            visited[currentId] = true
            currentVisited.add(currentId)
            graph[currentId].forEach { (d, v) ->
                if (!visited[v]) {
                    stack.add(v)
                }
            }
        }
        depth = currentVisited.size
        area = abs(area) - depth/2 +1 + (g.height - g.id2Node(startId)!!.y)
    }

    fun dfsRecursive(start: Int) {
        var currentDepth = 0
        currentVisited.clear()
        DeepRecursiveFunction<Int, Unit> { id ->
            visited[id] = true
            currentVisited.add(id)
            currentDepth++
            depth = if (depth > currentDepth) depth else currentDepth
            graph[id].forEach { (d, v) ->
                if (!visited[v]) {
                    this.callRecursive(v)
                }
            }
        }.invoke(start)
    }
}

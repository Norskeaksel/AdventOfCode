import days.readFileLines

fun day20a(input: List<String>, goal: Int, shadowToogle: Boolean = true): Int {
    val height = input.size
    val width = input[0].length
    var ans = 0
    val multiplier = if (shadowToogle) 2 else 1
    val grid = Grid(width * multiplier, height)
    var startId = -1
    var endId = -1
    var shadowEndId = 0
    input.forEachIndexed { y, line ->
        line.forEachIndexed { x, c ->
            val id = grid.xy2Id(x, y)!!
            if (c == 'S')
                startId = id
            if (c == 'E') {
                endId = id
                if (shadowToogle)
                    shadowEndId = grid.xy2Id(x + width, y)!!
            }

            val t1 = Grid.Tile(x, y, c)
            grid.addNode(t1)
            if (shadowToogle) {
                val t2 = Grid.Tile(x + width, y, c)
                grid.addNode(t2)
            }
        }
    }
    grid.printGrid()
    for (x in 0 until width * multiplier) {
        for (y in 0 until height) {
            val t = grid.xy2Node(x, y)!!
            val neighbours = grid.getStraightNeighbours(t)
            neighbours.forEach { v ->
                if ((v.data as Char) != '#')
                    grid.addEdge(t, v)
                else if (shadowToogle && x < width - 1) {
                    val shadowTile = Grid.Tile(v.x + width, v.y, v.data)
                    grid.addNode(shadowTile)
                    grid.addEdge(t, shadowTile)
                }
            }
        }
    }
    val bfs = BFS(grid.getAdjacencyList())
    bfs.bfsRecursive(listOf(startId))
    val fairDist = bfs.distances[endId].toInt()
    val dijkstra = Dijkstra(grid.getAdjacencyList())
    val shadowDist = dijkstra.distance[shadowEndId]
    dijkstra.dijkstra(startId)
    for (y in 0 until height) {
        for (x in 0 until width * multiplier) {
            val id = x + y * width * multiplier
            print(
                dijkstra.distance.map { if (it == Double.POSITIVE_INFINITY) -1 else it }[id].toInt().toString()
                    .padStart(3, ' ')
            )
        }
        println()
    }
    println("FairDist: $fairDist, ShadowDist: $shadowDist")
    return 1
}

fun day20b(input: List<String>): Int {
    var ans = 0
    input.forEach { line ->

    }
    return ans
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day20")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day20a(input, 100, true))
    println(day20b(input))
}
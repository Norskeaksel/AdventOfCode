package days

fun numbersConnectedToSymbol(input: List<String>): Int {
    val grid = Grid(input[0].length, input.size)
    initializeGrid(input, grid)
    val numbers = grid.getNodes().filter { it.data.toString().toIntOrNull() !in listOf(null, 0) }
    val partNumbers = mutableListOf<Int>()
    numbers.forEach { t ->
        val searcher = DFS(grid.getAdjacencyList())
        searcher.dfsIterative(grid.node2Id(t))
        if (searcher.depth > t.data.toString().length)
            partNumbers.add(t.data.toString().toInt())
    }
    println(partNumbers)
    return partNumbers.sum()
}

private fun initializeGrid(input: List<String>, grid: Grid, padWithDuplicates:Boolean = false) {
    repeat(2) {
        input.forEachIndexed { y, line ->
            val regex = Regex("\\d+|\\D+")
            val numbersAndSymbols = regex.findAll(line).map { it.value }.toList()
            var x = 0
            numbersAndSymbols.forEach { ns ->
                for (i in ns.indices) {
                    val value = when {
                        i == 0 && ns.toIntOrNull() != null -> ns
                        ns.toIntOrNull() != null -> if(padWithDuplicates) ns else "0"
                        else -> ns[i]
                    }
                    val t = Grid.Tile(x++, y, value)
                    if (it == 0)
                        grid.addNode(t)
                    else {
                        val neighbours =
                            grid.getAllNeighbours(t)
                                .filter { it.data != '.' && it.data.toString().toIntOrNull() in listOf(null, 0) }
                        neighbours.forEach { grid.addEdge(t, it) }
                    }
                }
            }
        }
    }
}

fun starWith2Numbers(input: List<String>): Long {
    val cleanedInput = mutableListOf<String>()
    input.forEach { line ->
        val newLine = line.map {
            if (it != '*' && !it.isDigit()) '.' else it
        }.joinToString("");
        cleanedInput.add(newLine)
    }
    val grid = Grid(input[0].length, input.size)
    initializeGrid(cleanedInput, grid, true)
    val gears = grid.getNodes().filter { it.data == '*' }
    val partNumbers = mutableListOf<Pair<Long, Long>>()
    gears.forEach { t ->
        val searcher = DFS(grid.getAdjacencyList())
        searcher.dfsRecursive(grid.node2Id(t))
        val numbers = grid.getAllNeighbours(t).filter { it.data.toString().toIntOrNull() !in (listOf(null, 0)) }.map { it.data }.toSet()
        if (numbers.size == 2)
            partNumbers.add(Pair(numbers.first().toString().toLong(), (numbers.last().toString().toLong())))
    }
    println(partNumbers)
    return partNumbers.sumOf { it.first * it.second }
}

fun main() {
    val input = readFileLines("_2023/inputFiles/Day3")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(numbersConnectedToSymbol(input))
    println(starWith2Numbers(input))
}

class DFS(val graph: AdjacencyList) {
    val size = graph.size
    var visited = BooleanArray(size)
    var depth = 0
    private var currentVisited = mutableListOf<Int>()

    fun dfsIterative(startId: Int) {
        currentVisited.clear()
        val stack = ArrayDeque<Int>()
        stack.add(startId)
        while (stack.isNotEmpty()) {
            val currentId = stack.last()
            stack.removeLast()
            if (visited[currentId])
                continue

            visited[currentId] = true
            currentVisited.add(currentId)
            graph[currentId].forEach { (d, v) ->
                if (!visited[v]) {
                    stack.add(v)
                }
            }
        }
        depth = currentVisited.size
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

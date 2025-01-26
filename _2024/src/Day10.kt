package days

import DFS
import Grid
import Tile

fun day10a(input: List<String>): Long {
    var ans = 0L
    val grid = Grid(input)
    grid.print()
    grid.getNodes().forEach { t ->
        grid.getStraightNeighbours(t).forEach { n ->
            if (n.data == t.data as Char + 1)
                grid.addEdge(t, n)
        }
    }
    grid.getNodes().forEach {
        val dfs = DFS(grid)
        if (it.data != '0')
            return@forEach
        dfs.dfsRecursive(grid.node2Id(it))
        val visitedNines = dfs.getCurrentVisited().count { grid.id2Node(it)?.data == '9' }
        ans += visitedNines
    }
    return ans
}

private fun buildGridAndIds(input: List<String>): Pair<Grid, MutableSet<Int>> {
    val grid = Grid(input[0].length, input.size)
    val targetIds = mutableSetOf<Int>()
    input.forEachIndexed { y, line ->
        line.forEachIndexed { x, c ->
            val t = Tile(x, y, c - '0')
            grid.addNode(t)
            if (c == '9') {
                targetIds.add(grid.node2Id(t))
            }
        }
    }
    grid.getNodes().forEach { node ->
        val neighbours = grid.getStraightNeighbours(node)
        neighbours.forEach { neighbour ->
            if (neighbour.data as Int == node.data as Int + 1)
                grid.addEdge(node, neighbour)
        }
    }
    return Pair(grid, targetIds)
}

fun day10b(input: List<String>): Int {
    val (grid, targetIds) = buildGridAndIds(input)
    val dfs = DFS(grid.getAdjacencyList())
    val sortedGraph = dfs.topologicalSort()
    val allPathsTo = IntArray(grid.trueSize())
    sortedGraph.forEach { id ->
        if (grid.id2Node(id)!!.data != 0)
            return@forEach
        allPathsTo[id] = 1
    }
    sortedGraph.forEach { id ->
        val node = grid.id2Node(id)!!
        grid.getStraightNeighbours(node).forEach {v ->
            if(v.data == node.data as Int + 1)
                allPathsTo[grid.node2Id(v)] += allPathsTo[id]
        }
    }
    val pathsToEndpoints = targetIds.map { allPathsTo[it] }
    val totalPaths = pathsToEndpoints.sum()
    return totalPaths
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day10")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day10a(input))
    println(day10b(input))
}
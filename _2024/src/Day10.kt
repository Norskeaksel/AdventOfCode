package days

import DFS
import Grid

fun day10a(input: List<String>): Long {
    var ans = 0L
    val grid = Grid(input[0].length, input.size)
    val targetIds = mutableSetOf<Int>()
    input.forEachIndexed { y, line ->
        line.forEachIndexed { x, c ->
            val t = Grid.Tile(x, y, c - '0')
            grid.addNode(t)
            if (c == '9'){
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
    grid.getNodes().forEach {
        val dfs = DFS(grid.getAdjacencyList())
        if(it.data != 0)
            return@forEach
        dfs.dfsRecursive(grid.node2Id(it))
        val visitedTargets = dfs.getCurrentVisited().intersect(targetIds)
        ans += visitedTargets.size
    }
    return ans
}

fun day10b(input: List<String>): Long {
    var ans = 0L
    input.forEach { line ->

    }
    return ans
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day10")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day10a(input))
    println(day10b(input))
}
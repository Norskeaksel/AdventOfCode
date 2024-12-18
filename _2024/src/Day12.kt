package days

import DFS
import Grid
import kotlin.math.abs

data class Region(val name: Char, var neighbours: Int = 0, var id:Int = -1)

fun day12a(input: List<String>): Long {
    var ans = 0L
    val grid = Grid(input[0].length, input.size)
    input.forEachIndexed { y, line ->
        line.forEachIndexed { x, c ->
            val r = Region(c)
            val t = Grid.Tile(x, y, r)
            grid.addNode(t)
        }
    }
    grid.getNodes().forEach { t ->
        val neighbours = grid.getStraightNeighbours(t)
        neighbours.forEach { n ->
            if ((n.data as Region).name == (t.data as Region).name) {
                grid.addEdge(t, n)
                (t.data as Region).neighbours++
            }
        }
    }
    val dfs = DFS(grid.getAdjacencyList())
    grid.getNodes().forEach { t ->
        dfs.dfsRecursive(grid.node2Id(t))
        val visitedNodes = dfs.getCurrentVisited()
        val area = visitedNodes.size
        if (area == 0)
            return@forEach
        val region = (t.data as Region).name
        val circumference = visitedNodes.sumOf { 4 - (grid.id2Node(it)!!.data as Region).neighbours }
        //  println("Region $region has area $area and circumference $circumference")
        ans += area * circumference
    }
    return ans
}

fun day12b(input: List<String>): Long {
    var ans = 0L
    val grid = Grid(input[0].length, input.size)
    input.forEachIndexed { y, line ->
        line.forEachIndexed { x, c ->
            val r = Region(c)
            val t = Grid.Tile(x, y, r)
            grid.addNode(t)
        }
    }
    grid.getNodes().forEach { t ->
        val neighbours = grid.getStraightNeighbours(t)
        neighbours.forEach { n ->
            if ((n.data as Region).name == (t.data as Region).name) {
                grid.addEdge(t, n)
                (t.data as Region).neighbours++
            }
        }
    }
    var idCount = 0
    val dfs = DFS(grid.getAdjacencyList())
    grid.getNodes().forEach { t ->
        dfs.dfsRecursive(grid.node2Id(t))
        val visitedNodes = dfs.getCurrentVisited()
        val area = visitedNodes.size
        if (area == 0)
            return@forEach
        visitedNodes.forEach {id ->
            (grid.nodes[id]!!.data as Region).id = idCount
        }
        idCount++
        val region = (t.data as Region).name
        val circumference = visitedNodes.sumOf { 4 - (grid.id2Node(it)!!.data as Region).neighbours }
        val corners = circumference - nodeEdgesCount(grid, (t.data as Region).id)
        // println("Region $region has area $area, circumference $circumference and $corners corners")
        ans += area * corners
    }
    return ans
}

fun nodeEdgesCount(grid: Grid, currentId: Int): Int {
    var ans = 0
    for (i in -1 until grid.height) {
        for (j in -1 until grid.width) {
            val square = mutableListOf<Int>()
            for (dy in 0..1) {
                for (dx in 0..1) {
                    val y = i + dy
                    val x = j + dx
                    square.add((grid.xy2Node(x, y)?.data as Region?)?.id ?: -1)
                }
            }

            val (x1y1, x2y1, x1y2, x2y2) = square
            // println("$x1y1$x2y1\n$x1y2$x2y2\n")
            val edgeBelow =
                x1y1 == currentId && x2y1 == currentId && x1y2 != currentId && x2y2 != currentId
            val edgeAbove =
                x1y2 == currentId && x2y2 == currentId && x1y1 != currentId && x2y1 != currentId
            val edgeLeft =
                x2y1 == currentId && x2y2 == currentId && x1y1 != currentId && x1y2 != currentId
            val edgeRight =
                x1y1 == currentId && x1y2 == currentId && x2y1 != currentId && x2y2 != currentId
            if (edgeBelow || edgeAbove || edgeLeft || edgeRight) {
                if(currentId == 1)
                    println("$x1y1$x2y1\n$x1y2$x2y2\n")
                ans++
            }
        }
    }
    return ans
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day12")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day12a(input))
    println(day12b(input))
}
package days

import DFS
import Grid

data class Region(val name: Char, var neighbours: Int = 0, var isCourner: Boolean = false)

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
        println("Region $region has area $area and circumference $circumference")
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
    val dfs = DFS(grid.getAdjacencyList())
    grid.getNodes().forEach { t ->
        dfs.dfsRecursive(grid.node2Id(t))
        val visitedNodes = dfs.getCurrentVisited()
        val area = visitedNodes.size
        if (area == 0)
            return@forEach
        val region = (t.data as Region).name
        val corners = countCorners(visitedNodes, grid)
        println("Region $region has area $area and $corners corners")
        ans += area * corners
    }
    return ans
}

private fun countCorners(visitedNodes: List<Int>, grid: Grid): Int {
    var corners = 0
    visitedNodes.forEach { id ->
        val neighbours = grid.getNeighboursOfId(id)
        when (neighbours.size) {
            0 -> corners += 4
            1 -> corners += 2
            2 -> if (neighbours.first().x != neighbours.last().x && neighbours.first().y != neighbours.last().y)
                corners += 1

            else -> corners += 0
        }
    }
    return corners
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day12")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day12a(input))
    println(day12b(input))
}
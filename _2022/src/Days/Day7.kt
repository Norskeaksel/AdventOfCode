package Days

import java.io.File

class Graph(private val size: Int) {
    data class Edge(val end:Int, val distance:Double)
    class Node {
        val distance: Double = Double.MAX_VALUE
        val neighbors = mutableListOf<Edge>()
    }
    val node = Array(size) { Node() }
    val distances = Array(size) { Double.MAX_VALUE }
    fun addEdge(from: Int, to: Int, distance: Double = 1.0) {
        node[from].neighbors.add(Edge(to, distance))
    }
    fun getAdjacent(nodeId: Int): List<Edge> = node[nodeId].neighbors
}

fun main() {
    val input = File("_2022/src/inputFiles/Day6").readText()
}

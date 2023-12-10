package days

data class Crossroad(val left: String, val right: String)

fun rightLeftSteps(input: List<String>): Int {
    val instructions = input[0]
    val graph = mutableMapOf<String, Crossroad>()
    input.forEachIndexed { i, line ->
        if (i < 2) return@forEachIndexed
        val (current, next) = line.split(" = (")
        var (left, right) = next.split(", ")
        right = right.replace(")", "")
        graph[current] = Crossroad(left, right)
    }
    var i = 0
    var current = "AAA"
    while (true) {
        val direction = instructions[i % instructions.length]
        current = if (direction == 'L') graph[current]!!.left else graph[current]!!.right
        i++
        if (current == "ZZZ")
            break
    }
    return i
}

fun rightLeftSteps2(input: List<String>): Long {
    val instructions = input[0]
    val graph = mutableMapOf<String, Crossroad>()
    val startNodes = mutableListOf<String>()
    input.forEachIndexed { i, line ->
        if (i < 2) return@forEachIndexed
        val (current, next) = line.split(" = (")
        if (current.last() == 'A')
            startNodes.add(current)

        var (left, right) = next.split(", ")
        right = right.replace(")", "")
        graph[current] = Crossroad(left, right)
    }
    System.err.println("${startNodes.size} nodes needed")
    for (n in 0 until startNodes.size) {
        var currentNodes = startNodes.toList()
        System.err.println("Searching for endnodes for node $n")
        var endnodes = 0
        var maxNrFound = 0
        var i = 0L
        while (true) {
            val direction = instructions[(i % instructions.length).toInt()]
            val newNodes = mutableListOf<String>()
            currentNodes.forEach {
                newNodes.add(if (direction == 'L') graph[it]!!.left else graph[it]!!.right)
            }
            i++
            if (i % 10_000_000 == 0L) {
                System.err.println(i)
            }
            newNodes[n].let {
                if (it.last() == 'Z')
                    endnodes++
            }
            if (endnodes > maxNrFound) {
                System.err.println("$endnodes found at step $i")
                maxNrFound = endnodes
            }
            if (endnodes == newNodes.size/2)
                break
            currentNodes = newNodes
        }
    }
    return 0
}

fun main() {
    val input = readFileLines("_2023/inputFiles/Day8")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    //println(day8(input))
    println(rightLeftSteps2(input))
}
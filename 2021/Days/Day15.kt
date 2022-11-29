import java.lang.StrictMath.abs
import java.lang.StrictMath.min

val INF = 123456789
const val dim = 500
var dist = Array(dim) { IntArray(dim) }
var done = Array(dim) { IntArray(dim) }
var nodes = mutableListOf<Pair<Int,Int>>()
val grid = mutableListOf<List<Int>>()

fun _init(){
    for(y in 0 until dim )
        for(x in 0 until dim) {
            nodes.add(Pair(x,y))
            done[y][x] = 0
            dist[y][x] = INF
        }
    dist[0][0]=0
}

fun _nearestNode():Pair<Int,Int>{
    var minDist = INF
    var minNode = Pair(-1,-1)
    for(node in nodes){
        val x = node.first
        val y = node.second
        if(done[y][x] == 0 && dist[y][x] < minDist){
            minDist = dist[y][x]
            minNode = node
        }
    }
    return minNode
}

fun dijkstra():Int {
    _init()
   for(row in 0 until dim){
       for(col in 0 until dim){
           //println(dist[col][row])
           val nearestNode = _nearestNode()
           val x = nearestNode.first
           val y = nearestNode.second
           done[y][x] = 1
           for(i in 0..1){
               val nx = x + (i==0).toInt()
               val ny = y + (i==1).toInt()
               if(nx<dim && ny < dim ){
                    val newDist = dist[y][x]+grid[ny][nx]
                    if(newDist < dist[ny][nx]){
                        dist[ny][nx] = newDist
                    }
               }
           }
       }
       println("Row: $row/$dim")
   }
    return dist[dim-1][dim-1]
}

fun part1(input: List<String>): Int {
        for(line in input){
            grid.add(line.toCharArray().map { (it-'0') })
        }
    return dijkstra()
}

fun main() {
    val path1 = "src/inputFiles/day15.txt"
    val path2 = "src/inputFiles/day15p2.txt"
    val input1 = readFileLns(path1)
    val input2 = readFileLns(path2)
    //val ans1 = part1(input)
    //println("Part 1 = $ans1")
    val ans2 = part1(input2); println("Part 2 = $ans2")
}


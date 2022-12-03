@file:JvmName("Day5Kt")

package Days

import java.lang.Math.*
import java.util.ArrayDeque

class Line() {
    val x1 = 0
    val y1 = 0
    val x2 = 0
    val y2 = 0
    fun isHorizontal(): Boolean {
        return y1 == y2
    }

    fun isVertical(): Boolean {
        return x1 == x2
    }
}

fun part1(input: List<String>): Int {
    val points = mutableMapOf<Pair<Int, Int>,Int>()
    var intersections = 0
    for (line in input) {
        val (x1, y1, x2, y2) = line.split(" ").map { it.toInt() }
        if(min(abs(x2-x1),abs(y2-y1))>0) continue
        //println(points)
        for (y in min(y1,y2)..max(y1,y2)) {
            for (x in min(x1,x2)..max(x1,x2)) {
                val xy = Pair(x,y)
                if(!points.contains(xy)){
                    points[xy]=1
                }
                else if(points[xy]==1){
                    //println("$x $y")
                    intersections++
                    points[xy]=2
                }
            }
        }
    }
    return intersections
}


fun part2(input: List<String>): Int {
    val points = mutableMapOf<Pair<Int, Int>,Int>()
    var intersections = 0
    for (line in input) {
        val (x1, y1, x2, y2) = line.split(" ").map { it.toInt() }
        val maxX = max(x1,x2)
        val minX = min(x1,x2)
        val maxY = max(y1,y2)
        val minY = min(y1,y2)
        val xSteps = maxX-minX
        if(xSteps == maxY-minY){
            var i=0
            while(i <= xSteps){
                val xDirection = if(x2-x1>0) 1 else -1
                val yDirection = if(y2-y1>0) 1 else -1
                val xy = Pair(x1+i*xDirection,y1+i*yDirection)
                if(!points.contains(xy)){
                    points[xy]=1
                }
                else if(points[xy]==1){
                    //println("$x $y")
                    intersections++
                    points[xy]=2
                    //println(xy)
                }
                i++
            }
        }
        else if(min(abs(x2-x1),abs(y2-y1))>0) continue
        //println(points)
        else{
        for (y in min(y1,y2)..max(y1,y2)) {
            for (x in min(x1,x2)..max(x1,x2)) {
                val xy = Pair(x,y)
                if(!points.contains(xy)){
                    points[xy]=1
                }
                else if(points[xy]==1){
                    //println("$x $y")
                    intersections++
                    points[xy]=2

                }
            }
        }
        }
    }
    return intersections
}


fun main(args: Array<String>) {
    val path = "src/inputFiles/day5.txt"
    val input = readFileLns(path)
    val ans1 = part1(input)
    println("Part 1 = $ans1")
    val ans2 = part2(input)
    println("Part 2 = $ans2")
}


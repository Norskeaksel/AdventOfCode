package days

import kotlin.math.min

fun day5(input: List<String>): Long {
    val seeds = input[0].split(": ")[1].split(" ").map { it.toLong() }
    val maps = generateMaps(input)
    val endings = mutableListOf<Long>()
    val roads = mutableListOf<MutableList<Long>>()
    seeds.forEachIndexed { c, s ->
        var current = s
        roads.add(mutableListOf(current))
        (0 until maps.size).forEach { i ->
            val map = maps[i]
            for ((k, v) in map) {
                if (current in k.start..k.end) {
                    current += v.start - k.start
                    roads[c].add(current)
                    return@forEach
                }
            }
            roads[c].add(current)
        }
        endings.add(current)
        //System.err.println("Roads: ${roads[c]}")
    }
    //System.err.println("Endings $endings")
    return endings.min()
}

data class Interval(val start: Long, val end: Long)

fun generateMaps(input: List<String>): MutableList<MutableMap<Interval, Interval>> {
    val blocks = input.joinToString("\n").split("\n\n")
    val maps = mutableListOf<MutableMap<Interval, Interval>>()
    blocks.forEach { block ->
        val layerMap = mutableMapOf<Interval, Interval>()
        block.split("\n").forEach { line ->
            if (":" in line)
                return@forEach
            val (destinationRangeStart, sourceRangeStart, rangeLength) = line.trim().split(" ").map { it.toLong() }
            val fromInterval = Interval(sourceRangeStart, sourceRangeStart + rangeLength)
            val toInterval = Interval(destinationRangeStart, destinationRangeStart + rangeLength)
            layerMap[fromInterval] = toInterval
        }
        maps.add(layerMap)
    }
    return maps
}

fun day52(input: List<String>): Long {
    val seedRanges = input[0].split(": ")[1].split(" ").map { it.toLong() }
    var bestEnd = Long.MAX_VALUE
    for(i in seedRanges.indices step 2){
        System.err.println("Going from ${seedRanges[i]} to ${seedRanges[i+1]}")
        for(s in seedRanges[i] until seedRanges[i]+seedRanges[i+1]){
            val newInput = input.toMutableList()
            newInput[0] = "seeds: $s"
            bestEnd = min(bestEnd,day5(newInput) )
        }
    }
    return bestEnd
}

fun main() {
    val input = readFileLines("_2023/inputFiles/Day5")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day5(input))
    println(day52(input))
}


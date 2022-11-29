fun printGrid(grid: MutableList<MutableList<Int>>) {
    grid.forEach { println(it) }
    println()
}

fun _incrementAdjacencies(input: MutableList<MutableList<Int>>, x: Int, y: Int): MutableList<MutableList<Int>> {
    //input.forEach { println(it) }
    //println()
    myloop@for (i in -1..1) {
        for (j in -1..1) {
            val nx: Int = x + i
            val ny: Int = y + j
            if (nx >= 0 && nx < input[0].size && ny >= 0 && ny < input.size) {
                //println("nx=$nx ny=$ny")
                //input.forEach { println(it) }
                input[ny][nx]++
                //println()
                //break@myloop
            }
        }
    }
    //input.forEach { println(it) }
    //println()
    return input
}

fun _add1(input: MutableList<MutableList<Int>>) {
    for (row in 0 until input.size) {
        for (col in 0 until input[0].size) {
            ++input[row][col]
        }
    }
}

fun part1(input: MutableList<MutableList<Int>>, steps:Int): Int {
    var grid = input
    var score = 0
    for (i in 1..steps) {
        var hasntFlashed = mutableListOf<MutableList<Boolean>>()
        for(k in 1..input.size){
            hasntFlashed.add(MutableList(input[0].size) { true })
        }
        //printGrid(grid)
        _add1(grid)
        //input.forEach { println(it) }
        //println()
        for (j in 1..123) {
            for (row in 0 until grid.size) {
                for (col in 0 until grid[0].size) {
                    if (grid[row][col] > 9 && hasntFlashed[row][col] ) {
                        hasntFlashed[row][col] = false
                        score++
                        /*println("row=$row col=$col")
                        grid.forEach { println(it) }
                        println()*/
                        grid = _incrementAdjacencies(grid, col, row)
                        /*grid.forEach { println(it) }
                        println()*/
                    }
                }
            }
        }
        for (row in 0 until grid.size) {
            for (col in 0 until grid[0].size) {
                if (grid[row][col] > 9) {
                    grid[row][col] = 0
                }
            }
        }
    }
    return score
}

fun part2(input: MutableList<MutableList<Int>>): Int {
    var oldscore = 0
    var score = 0
    var steps = 0
    val octos = input.size*input[0].size

    do{
        val boardCopy = mutableListOf<MutableList<Int>>()
        input.forEach { boardCopy.add(it.toMutableList()) }
        //printGrid(boardCopy)
        oldscore=score
        steps++
        score = part1(boardCopy,steps)
    } while(score-oldscore<octos)
    return steps
}

fun main(args: Array<String>) {
    val path = "src/inputFiles/day11.txt"
    val input = readGrid(path)
    val boardCopy = copy2Dlist(input)
    val ans1 = part1(input, 4)
    println("Part 1 = $ans1")
    val ans2 = part2(boardCopy)
    println("Part 2 = $ans2")
}


import days.readFileLines
import kotlin.math.min

data class Direction(val x: Int, val y: Int)

fun day4a(input: List<String>): Int {
    var ans = 0
    val grid = mutableListOf<String>()
    input.forEach { line ->
        grid.add(line)
    }
    val y_max = grid.size
    val x_max = grid[0].length
    val directions = mutableListOf<Direction>()
    for (i in -1..1)
        for (j in -1..1)
            directions.add(Direction(i, j))
    for (dir in directions) {
        for (y in 0 until x_max) {
            for (x in 0 until y_max) {
                val c_y = y
                val c_x = x
                var word = ""
                for (i in 0..3) {
                    val n_x = c_x + i * dir.x
                    val n_y = c_y + i * dir.y
                    if (min(n_x, n_y) < 0 || n_y == y_max || n_x == x_max)
                        break
                    word += grid[n_y][n_x]
                }
                if (word == "XMAS") {
                    ans++
                }
            }
        }
    }
    return ans
}

fun day4b(input: List<String>): Int {
    var ans = 0
    val grid = mutableListOf<String>()
    input.forEach { line ->
        grid.add(line)
    }
    val y_max = grid.size
    val x_max = grid[0].length
    for (y in 1 until x_max - 1) {
        for (x in 1 until y_max - 1) {
            if (grid[y][x] != 'A')
                continue
            val downRight = grid[y - 1][x - 1] == 'M' && grid[y + 1][x + 1] == 'S'
            val downLeft = grid[y - 1][x + 1] == 'M' && grid[y + 1][x - 1] == 'S'
            val upRight = grid[y - 1][x + 1] == 'S' && grid[y + 1][x - 1] == 'M'
            val upLeft = grid[y - 1][x - 1] == 'S' && grid[y + 1][x + 1] == 'M'
            if ( listOf(downRight, downLeft, upRight, upLeft).count { it } > 1){
                println("y=$y,x=$x:")
                for(i in y-1..y+1){
                    for(j in x-1..x+1){
                        print(grid[i][j])
                    }
                    println()
                }
                ans++
            }
        }
    }
    return ans
}

fun main() {
    val input = readFileLines("_2024/inputFiles/Day4")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day4a(input))
    println(day4b(input))
}
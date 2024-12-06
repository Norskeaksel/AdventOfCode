import days.readFileLines

var ans = 1
fun day6a(grid: List<String>): Int {
    var cx = -1
    var cy = -1
    var lineNr = -1
    var direction = Direction(0, -1)
    grid.forEach { line ->
        println(line)
        lineNr++
        if ('^' in line) {
            cy = lineNr
            cx = line.indexOf('^')
        }
    }
    val visited = mutableSetOf(Direction(cx, cy))
    val x_lim = grid[0].length
    val y_lim = grid.size
    while (true) {
        val ny = cy + direction.y
        val nx = cx + direction.x
        if (nx !in 0 until x_lim || ny !in 0 until y_lim)
            break
        if (grid[ny][nx] == '#') {
            direction.run {
                when {
                    x == 0 && y == -1 -> direction = Direction(1, 0)
                    x == 1 && y == 0 -> direction = Direction(0, 1)
                    x == 0 && y == 1 -> direction = Direction(-1, 0)
                    x == -1 && y == 0 -> direction = Direction(0, -1)
                }
            }
        } else {
            cx = nx
            cy = ny
            val position = Direction(cx, cy)
            if (position !in visited){
                ans++
            }
            visited.add(position)
            println("cx=$cx, cy=$cy, ans=$ans")
        }
    }
    return ans
}

fun day6b(input: List<String>): Int {
    ans = 1
}

fun main() {
    val grid = mutableListOf<String>()
    val input = readFileLines("_2024/inputFiles/Day6").forEach { line ->
        grid.add(line)
    }
    println(day6a(grid))
    println(day6b(grid))
}
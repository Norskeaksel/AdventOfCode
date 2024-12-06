import days.readFileLines

fun day6a(grid: List<String>): Int {
    var ans = 1
    var cx = -1
    var cy = -1
    var lineNr = -1
    var direction = Direction(0, -1)
    var steps = 0
    grid.forEach { line ->
        // println(line)
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
            steps++
            if (position !in visited) {
                ans++
            }
            visited.add(position)
            // println("cx=$cx, cy=$cy, ans=$ans")
        }
        if (steps > 10_000){
            grid.forEach { line ->
                // println(line)
            }
            return Int.MAX_VALUE
        }
    }
    return ans
}

fun day6b(grid: MutableList<String>): Int {
    var newAns = 0
    for (y in 0 until grid.size) {
        for (x in 0 until grid[0].length) {
            if (grid[y][x] == '#')
                continue
            var c = -1
            val oldString = grid[y]
            val newString = grid[y].map {
                c++
                if (c == x)
                    '#'
                else
                    it
            }.joinToString("")
            grid[y] = newString
            if(day6a(grid) == Int.MAX_VALUE){
                newAns++
                // println("y=$y,x=$x")
            }
            grid[y] = oldString
        }
    }
    return newAns
}

fun main() {
    val grid = mutableListOf<String>()
    readFileLines("_2024/inputFiles/Day6").forEach { line ->
        grid.add(line)
    }
    println(day6a(grid))
    println(day6b(grid))
}
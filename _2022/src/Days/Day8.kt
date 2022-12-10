package Days

import kotlin.math.max

fun isVisibleDigit(grid: List<String>, x: Int, y: Int): Int {
    val tree = grid[y][x]
    val height = grid.size
    val width = grid[0].length
    var prev = '0'
    for (left in 0..x) {
        prev = if (left == 0) {
            grid[y][left]
        } else {
            if (tree <= prev) {
                break
            }
            grid[y][left]
        }
        if (left == x) {
            return 1
        }
    }
    for (right in width - 1 downTo x) {
        prev = if (right == width - 1) {
            grid[y][right]
        } else {
            if (tree <= prev) {
                break
            }
            grid[y][right]
        }
        if (right == x) {
            return 1
        }
    }
    for (top in 0..y) {
        prev = if (top == 0) {
            grid[top][x]
        } else {
            if (tree <= prev) {
                break
            }
            grid[top][x]
        }
        if (top == y) {
            return 1
        }
    }
    for (bottom in height - 1 downTo y) {
        prev = if (bottom == height - 1) {
            grid[bottom][x]
        } else {
            if (tree <= prev) {
                break
            }
            grid[bottom][x]
        }
        if (bottom == y) {
            return 1
        }
    }
    //println("Hidden digit at $y, $x")
    return 0
}

fun countVisibleDigit2(grid: List<String>, x: Int, y: Int): Long {
    val tree = grid[y][x]
    val height = grid.size
    val width = grid[0].length
    var next = '0'
    var leftCount = 0L
    var rightCount = 0L
    var topCount = 0L
    var bottomCount = 0L
    for (left in x downTo 0) {
        if (left == x)
            next = grid[y][left]
        else {
            leftCount++
            next = grid[y][left]
            if (tree <= next) {
                break
            }
        }
    }
    for (right in x until width) {
        if (right == x) {
            next = grid[y][right]
        } else {
            rightCount++
            next = grid[y][right]
            if (tree <= next) {
                break
            }
        }
    }
    for (top in y downTo 0) {
        if (top == y)
            next = grid[top][x]
        else {
            topCount++
            next = grid[top][x]
            if (tree <= next) {
                break
            }
        }
    }
    for (bottom in y until height) {
        if (bottom == y)
            next = grid[bottom][x]
        else {
            bottomCount++
            next = grid[bottom][x]
            if (tree <= next) {
                break
            }
        }
    }
    return leftCount * rightCount * topCount * bottomCount
}

fun countIncreasingDigitsFromEdges(str: String): Int {
    val grid = str.split('\n')
    val height = grid.size
    val width = grid[0].length
    var count = 0
    for (y in 0 until height) {
        for (x in 0 until width) {
            count += isVisibleDigit(grid, x, y)
        }
    }
    return count
}

fun countDecreasingDigitsFromTree(str: String): Long {
    val grid = str.split('\n')
    val height = grid.size
    val width = grid[0].length
    var ans = 0L
    for (y in 0 until height) {
        for (x in 0 until width) {
            ans = max(ans, countVisibleDigit2(grid, x, y))
        }
    }
    return ans
}

fun main() {
    val input = readFile("_2022/src/inputFiles/Real8")
    println(countIncreasingDigitsFromEdges(input))
    println(countDecreasingDigitsFromTree(input))
}

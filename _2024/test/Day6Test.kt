import junit.framework.TestCase

class Day6Test : TestCase() {
    val grid = mutableListOf<String>()
    val input = """
        ....#.....
        .........#
        ..........
        ..#.......
        .......#..
        ..........
        .#..^.....
        ........#.
        #.........
        ......#...
    """.trimIndent().lines().also {
        it.forEach { line ->
            grid.add(line)
        }
    }

    fun test1() {
        val ans = day6a(grid)
        assertEquals(41, ans)
    }

    fun test2() {
        val ans = day6b(grid)
        assertEquals(6, ans)
    }
}

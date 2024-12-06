import junit.framework.TestCase

class Day6Test : TestCase() {
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
    """.trimIndent().lines()

    fun test1() {
        val ans = day6a(input)
        assertEquals(41, ans)
    }
    fun test2() {
        val ans = day6b(input)
        assertEquals(6, ans)
    }
}

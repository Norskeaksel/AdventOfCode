import days.countTrees
import days.countTrees2
import junit.framework.Assert
import junit.framework.TestCase

class Day3KtTest: TestCase() {
    val input = """
        ..##.......
        #...#...#..
        .#....#..#.
        ..#.#...#.#
        .#...##..#.
        ..#.##.....
        .#.#.#....#
        .#........#
        #.##...#...
        #...##....#
        .#..#...#.#
    """.trimIndent().lines()

    fun testCounting() {
        val ans = countTrees(input)
        assertEquals(7, ans)
    }
    fun testCounting2(){
        val ans = countTrees2(input)
        Assert.assertEquals(336, ans)
    }
}

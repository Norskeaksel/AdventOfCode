import junit.framework.TestCase

class Day20Test : TestCase() {
    val input = """
        ###############
        #...#...#.....#
        #.#.#.#.#.###.#
        #S#...#.#.#...#
        #######.#.#.###
        #######.#.#...#
        #######.#.###.#
        ###..E#...#...#
        ###.#######.###
        #...###...#...#
        #.#####.#.###.#
        #.#...#.#.#...#
        #.#.#.#.#.#.###
        #...#...#...###
        ###############
    """.trimIndent().lines()

    fun test1() {
        val ans = day20a(input,30, 84)
        assertEquals(4, ans)
    }
    fun test2() {
        val ans = day20b(input,50, 84)
        assertEquals(285, ans)
    }
}

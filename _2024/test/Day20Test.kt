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
        val ans = day20a(input,40)
        assertEquals(2, ans)
    }
    fun test2() {
        val ans = day0b(input)
        assertEquals(0, ans)
    }
}

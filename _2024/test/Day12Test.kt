import days.day12a
import days.day12b
import junit.framework.Assert
import junit.framework.TestCase

class Day12Test : TestCase() {
    val input1 = """
        AAAA
        BBCD
        BBCC
        EEEC
    """.trimIndent().lines()

    val input2 = """
        OOOOO
        OXOXO
        OOOOO
        OXOXO
        OOOOO
    """.trimIndent().lines()

    val input3 = """
        RRRRIICCFF
        RRRRIICCCF
        VVRRRCCFFF
        VVRCCCJFFF
        VVVVCJJCFE
        VVIVCCJJEE
        VVIIICJJEE
        MIIIIIJJEE
        MIIISIJEEE
        MMMISSJEEE
    """.trimIndent().lines()

    val input4 = """
    EEEEE
    EXXXX
    EEEEE
    EXXXX
    EEEEE
""".trimIndent().lines()

    fun test1a() {
        val ans = day12a(input1)
        assertEquals(140, ans)
    }

    fun test1b() {
        val ans = day12a(input2)
        assertEquals(772, ans)
    }

    fun test1c() {
        val ans = day12a(input3)
        assertEquals(1930, ans)
    }

    fun test2a() {
        val ans = day12b(input1)
        assertEquals(80, ans)
    }

    fun test2b() {
        val ans = day12b(input4)
        Assert.assertEquals(236, ans)
    }
}

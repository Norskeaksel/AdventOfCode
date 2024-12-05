import junit.framework.TestCase

class Day4Test : TestCase() {
    val input = """
        MMMSXXMASM
        MSAMXMSMSA
        AMXSXMAAMM
        MSAMASMSMX
        XMASAMXAMM
        XXAMMXXAMA
        SMSMSASXSS
        SAXAMASAAA
        MAMMMXMMMM
        MXMXAXMASX
    """.trimIndent().lines()

    fun test1Day0() {
        val ans = day4a(input)
        assertEquals(18, ans)
    }
    fun test2Day0() {
        val ans = day4b(input)
        assertEquals(0, ans)
    }
}

import junit.framework.TestCase

class Day1Test : TestCase() {
    val input = """
        3   4
        4   3
        2   5
        1   3
        3   9
        3   3
    """.trimIndent().lines()

    fun test1() {
        val ans = day1a(input)
        assertEquals(11, ans)
    }
    fun test2() {
        val ans = day1b(input)
        assertEquals(31, ans)
    }
}

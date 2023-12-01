import days.solve
import days.solve2
import junit.framework.TestCase

class Day2KtTest : TestCase() {
    val input = """
    """.trimIndent().lines()

    fun testDay1() {
        val ans = solve(input)
        assertEquals(-1, ans)
    }
    fun testDay2() {
        val ans = solve2(input)
        assertEquals(ans, ans)
    }
}
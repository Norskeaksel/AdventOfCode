import days.day6
import days.day62
import junit.framework.TestCase

class Day6KtTest : TestCase() {
    val input = """
        Time:      7  15   30
        Distance:  9  40  200
    """.trimIndent().lines()

    fun test1Day0() {
        val ans = day6(input)
        assertEquals(288, ans)
    }
    fun test2Day0() {
        val ans = day62(input)
        assertEquals(71503, ans)
    }
}

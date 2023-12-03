import days.day4
import days.day42
import junit.framework.TestCase

class Day4KtTest : TestCase() {
    val input = """
    """.trimIndent().lines()

    fun test1Day0() {
        val ans = day4(input)
        assertEquals(1, ans)
    }
    fun test2Day0() {
        val ans = day42(input)
        assertEquals(0, ans)
    }
}

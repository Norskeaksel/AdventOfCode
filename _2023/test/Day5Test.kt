import days.day5
import days.day52
import junit.framework.TestCase

class Day5KtTest : TestCase() {
    val input = """
    """.trimIndent().lines()

    fun test1Day0() {
        val ans = day5(input)
        assertEquals(1, ans)
    }
    fun test2Day0() {
        val ans = day52(input)
        assertEquals(0, ans)
    }
}

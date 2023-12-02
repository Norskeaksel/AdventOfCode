import days.day3
import days.day32
import junit.framework.TestCase

class Day3KtTest : TestCase() {
    val input = """
    """.trimIndent().lines()

    fun test1Day3() {
        val ans = day3(input)
        assertEquals(1, ans)
    }
    fun test2Day3() {
        val ans = day32(input)
        assertEquals(0, ans)
    }
}

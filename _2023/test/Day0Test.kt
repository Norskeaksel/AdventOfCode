import days.day0
import days.day02
import junit.framework.TestCase

class Day0KtTest : TestCase() {
    val input = """
    """.trimIndent().lines()

    fun test1Day0() {
        val ans = day0(input)
        assertEquals(1, ans)
    }
    fun test2Day0() {
        val ans = day02(input)
        assertEquals(0, ans)
    }
}

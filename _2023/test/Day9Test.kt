import days.day9
import days.day92
import junit.framework.TestCase

class day9KtTest : TestCase() {
    val input = """
        0 3 6 9 12 15
        1 3 6 10 15 21
        10 13 16 21 30 45
    """.trimIndent().lines()

    fun test1day9() {
        val ans = day9(input)
        assertEquals(114, ans)
    }
    fun test2day9() {
        val ans = day92(input)
        assertEquals(2, ans)
    }
}

import days.day2a
import days.day2b
import junit.framework.TestCase

class Day2Test : TestCase() {
    val input = """
        7 6 4 2 1
        1 2 7 8 9
        9 7 6 2 1
        1 3 2 4 5
        8 6 4 4 1
        1 3 6 7 9
    """.trimIndent().lines()

    fun test1() {
        val ans = day2a(input)
        assertEquals(2, ans)
    }
    fun test2() {
        val ans = day2b(input)
        assertEquals(4, ans)
    }
}

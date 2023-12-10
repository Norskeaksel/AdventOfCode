import days.sumOfDifferences
import days.sumOfDiffrences2
import junit.framework.TestCase

class day9KtTest : TestCase() {
    val input = """
        0 3 6 9 12 15
        1 3 6 10 15 21
        10 13 16 21 30 45
    """.trimIndent().lines()

    fun test1day9() {
        val ans = sumOfDifferences(input)
        assertEquals(114, ans)
    }
    fun test2day9() {
        val ans = sumOfDiffrences2(input)
        assertEquals(2, ans)
    }
}

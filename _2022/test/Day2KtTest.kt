import junit.framework.TestCase

class DayKtTest : TestCase() {
    val input = """ 
A Y
B X
C Z
    """.trimIndent().lines()

    fun testSolve1() {
        val ans = rockPaper1(input)
        assertEquals(15, ans)
    }

    fun testSolve2() {
        val ans = rockPaper2(input)
        assertEquals(12,ans)
    }
}

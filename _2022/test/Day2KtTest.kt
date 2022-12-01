import junit.framework.TestCase

class DayKtTest : TestCase() {
    val input = """ 
        
    """.trimIndent().lines()

    fun testSolve1() {
        val ans = solve1(input)
        assertEquals(Any(), ans)
    }

    fun testSolve2() {
        val ans = solve2(input)
        //assertEquals(-1,ans)
    }
}

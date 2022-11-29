import Days.solve1
import Days.solve2
import junit.framework.TestCase

class DayKtTest : TestCase() {
    val input = """ 
       BFFFBBFRRR
       FFFBBBFRRR
       BBFFBBFRLL
    """.trimIndent().lines()

    fun testSolve1() {
        val ans = solve1(input)
        assertEquals(820, ans)
    }

    fun testSolve2() {
        val ans = solve2(input)
        //assertEquals(-1,ans)
    }
}

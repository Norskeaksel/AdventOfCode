import junit.framework.TestCase

class Day1KtTest : TestCase() {
    val input = """ 
1000
2000
3000

4000

5000
6000

7000
8000
9000

10000

    """.trimIndent().lines()

    fun testSolve1() {
        val ans = solve(input)[0]
        assertEquals(24000, ans)
    }

    fun testSolve2() {
        //val ans = solve2(input)
        //assertEquals(-1,ans)
    }
}

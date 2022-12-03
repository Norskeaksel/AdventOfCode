import Days.solve1
import Days.solve2
import junit.framework.TestCase

class DayKt3Test : TestCase() {
    val input = """ 
vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg

wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw

    """.trimIndent().lines()

    fun testSolve1() {
        val ans = solve1(input)
        assertEquals(157, ans)
    }

    fun testSolve2() {
        val ans = solve2(input)
        assertEquals(70,ans)
    }
}

import Days.findCompleatIntevalOverlap
import Days.findOverlappingInterval
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
        val ans = findCompleatIntevalOverlap(input)
        assertEquals(157, ans)
    }

    fun testSolve2() {
        val ans = findOverlappingInterval(input)
        assertEquals(70,ans)
    }
}

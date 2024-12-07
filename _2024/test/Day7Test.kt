import days.day7a
import days.day7b
import junit.framework.TestCase

class Day7Test : TestCase() {
    val input = """
        190: 10 19
        3267: 81 40 27
        83: 17 5
        156: 15 6
        7290: 6 8 6 15
        161011: 16 10 13
        192: 17 8 14
        21037: 9 7 18 13
        292: 11 6 16 20
    """.trimIndent().lines()

    fun test1() {
        val ans = day7a(input)
        assertEquals(3749, ans)
    }
    fun test2() {
        val ans = day7b(input)
        assertEquals(11387, ans)
    }
}

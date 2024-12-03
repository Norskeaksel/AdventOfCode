import days.day3a
import days.day3b
import junit.framework.TestCase

class Day3Test : TestCase() {
    val input = """
        xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))
    """.trimIndent().lines()

    fun test1Day0() {
        val ans = day3a(input)
        assertEquals(161, ans)
    }
    fun test2Day0() {
        val ans = day3b(input)
        assertEquals(0, ans)
    }
}

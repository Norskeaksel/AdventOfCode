import days.day7
import days.day72
import junit.framework.TestCase

class Day7KtTest : TestCase() {
    val input = """
        32T3K 765
        T55J5 684
        KK677 28
        KTJJT 220
        QQQJA 483
    """.trimIndent().lines()

    fun test1Day7() {
        val ans = day7(input)
        assertEquals(1, ans)
    }
    fun test2Day7() {
        val ans = day72(input)
        assertEquals(0, ans)
    }
}

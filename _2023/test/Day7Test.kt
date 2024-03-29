import days.dessertPoker
import days.dessertPoker2
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
        val ans = dessertPoker(input)
        assertEquals(6440, ans)
    }
    fun test2Day7() {
        val ans = dessertPoker2(input)
        assertEquals(5905, ans)
    }
}

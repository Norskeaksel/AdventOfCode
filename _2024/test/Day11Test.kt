import junit.framework.TestCase

class Day11Test : TestCase() {
    val input = "125 17"

    fun test1() {
        val ans = day11a(input)
        assertEquals(55312, ans)
    }

    fun test2() {
        val ans = day11b(input)
        assertEquals(0, ans)
    }
}

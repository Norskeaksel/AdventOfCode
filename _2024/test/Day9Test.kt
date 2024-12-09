import days.day9a
import days.day9b
import junit.framework.TestCase

class Day9Test : TestCase() {
    val input = "2333133121414131402"

    fun test1() {
        val ans = day9a(input)
        assertEquals(1928, ans)
    }
    fun test2() {
        val ans = day9b(input)
        assertEquals(2858, ans)
    }
}

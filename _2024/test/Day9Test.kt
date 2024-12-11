import days.day9a
import days.day9b
import junit.framework.TestCase
import kotlin.math.pow
import kotlin.random.Random

class Day9Test : TestCase() {
    val input = "2333133121414131402"
    val input2 ="233313312141413140202333133121414131402"
    val input3 = "1313165"
    val input4 = "80893804751608292"
    val n = 15
    // val randomInput = Random.nextLong(10.0.pow(n - 1).toLong(), 10.0.pow(n).toLong()).toString()


    fun test1() {
        val ans = day9a(input)
        assertEquals(1928, ans)
    }
    fun test2() {
        val ans = day9b(input)
        assertEquals(2858, ans)
    }
    fun test2b() {
        val ans = day9b(input2)
        assertEquals(23423, ans)
    }
    fun test2c() {
        val ans = day9b(input3)
        assertEquals(169, ans)
    }
    fun test2d() {
        val ans = day9b(input4)
        assertEquals(1715, ans)
    }
    /*fun test2e() {
        println("input=$randomInput")
        println(day9b(randomInput))
    }*/

}

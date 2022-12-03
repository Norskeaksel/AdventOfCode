import junit.framework.Assert.assertEquals
import junit.framework.TestCase
import org.junit.Test

class Day11Test : TestCase(){
    @Test
    fun testD11p1() {
        val testPath = "src/testInputFiles/day11.txt"
        val testinput = readGrid(testPath)
        val expected = 1656
        assertEquals(expected, part1(testinput, 100))
    }
    @Test
    fun testCustomD11p1() {
        val testPath = "src/testInputFiles/customDay11.txt"
        val testinput = readGrid(testPath)
        val expected = 3
        assertEquals(expected, part1(testinput, 1))
    }
}

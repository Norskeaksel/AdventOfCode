import days.countSlidingWindowIncreases
import days.readFileIntLines
import junit.framework.TestCase

class Day1Test: TestCase(){

    fun testD1p2() {
        val testPath = "test/testInputFiles/d1.txt"
        val testinput = readFileIntLines(testPath)
        val expected = 5
        assertEquals(expected, countSlidingWindowIncreases(testinput))
    }
}

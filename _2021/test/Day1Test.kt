import Days.countSlidingWindowIncreases
import Days.readFileIntLines
import junit.framework.TestCase
import org.junit.jupiter.api.Test

class Day1Test: TestCase(){

    @Test
    fun testD1p2() {
        val testPath = "test/testInputFiles/d1.txt"
        val testinput = readFileIntLines(testPath)
        val expected = 5
        assertEquals(expected, countSlidingWindowIncreases(testinput))
    }
}

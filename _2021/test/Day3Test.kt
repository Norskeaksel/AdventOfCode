import Days.mostCommonChars2
import Days.readFileLines
import junit.framework.TestCase
import org.junit.jupiter.api.Test

class Day3Test : TestCase() {
    @Test
    fun testD3p2() {
        val testPath = "test/testInputFiles/day3.txt"
        val testinput = readFileLines(testPath)
        val expected = "10111o 01010c"
        assertEquals(expected, mostCommonChars2(testinput))
    }
}

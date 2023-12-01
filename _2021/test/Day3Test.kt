import days.mostCommonChars2
import days.readFileLines
import junit.framework.TestCase

class Day3Test : TestCase() {
    fun testD3p2() {
        val testPath = "test/testInputFiles/day3.txt"
        val testinput = readFileLines(testPath)
        val expected = "10111o 01010c"
        assertEquals(expected, mostCommonChars2(testinput))
    }
}

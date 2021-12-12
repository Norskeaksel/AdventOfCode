import junit.framework.TestCase
import org.junit.Test

class Day5Test : TestCase() {
    @Test
    fun testD5p1() {
        val testPath = "src/testInputFiles/day5.txt"
        val testinput = readFileLns(testPath)
        val expected = 5
        assertEquals(expected, part1(testinput))
    }
    @Test
    fun testD5p2() {
        val testPath = "src/testInputFiles/day5.txt"
        val testinput = readFileLns(testPath)
        val expected = 12
        assertEquals(expected, part2(testinput))
    }
}

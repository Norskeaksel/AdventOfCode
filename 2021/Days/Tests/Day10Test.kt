import junit.framework.TestCase
import org.junit.Test

class Day10Test : TestCase() {

    @Test
    fun testD10p1() {
        val testPath = "src/testInputFiles/day10.txt"
        val testinput = readFileLns(testPath)
        val expected = 26397
        assertEquals(expected, part1(testinput))
    }

    @Test
    fun testD10p2() {
        val testPath = "src/testInputFiles/day10.txt"
        val testinput = readFileLns(testPath)
        val expected = 288957L
        assertEquals(expected, part2(testinput))
    }
}

import junit.framework.TestCase
import org.junit.Test

class Day15Test : TestCase() {

    @Test
    fun testD15p1() {
        val testPath = "src/testInputFiles/day15.txt"
        val testinput = readFileLns(testPath)
        val expected = 40
        assertEquals(expected, part1(testinput))
    }
}

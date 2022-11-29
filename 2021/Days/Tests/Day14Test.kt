import junit.framework.TestCase
import org.junit.Test

class Day14Test : TestCase(){
    @Test
    fun testDay14() {
        val testPath = "src/testInputFiles/day14.txt"
        val testinput = readFileLns(testPath)
        val expected = 1588
        assertEquals(expected, part1(testinput,10))
    }

}

import junit.framework.TestCase
import org.junit.Test

class Day4Test : TestCase() {
    @Test
    fun testSampleInput() {
        val testPath = "src/testInputFiles/day4.txt"
        val testinput = readFileLns(testPath)
        val expected = 4512
        assertEquals(expected, part1(testinput))
    }
    @Test
    fun testCustomInput() {
        val testPath = "src/testInputFiles/customDay4.txt"
        val testinput = readFileLns(testPath)
        val expected = 0
        assertEquals(expected, part1(testinput))
    }
   @Test
   fun testSampleInput2(){
       val testPath = "src/testInputFiles/day4.txt"
       val testinput = readFileLns(testPath)
       val expected = 1924
       assertEquals(expected, part2(testinput))
   }
}

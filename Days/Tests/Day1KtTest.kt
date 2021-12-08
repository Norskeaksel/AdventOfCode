import junit.framework.TestCase
import org.junit.Test

class Day1KtTest : TestCase(){

    @Test
    fun testD1p2() {
        val testPath = "src/testInputFiles/d1p1.txt"
        val testinput = readFileIntLns(testPath)
        val expected = 5
        assertEquals(expected, part2(testinput))
    }
}
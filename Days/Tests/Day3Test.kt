import junit.framework.TestCase
import org.junit.Test

class Day3Test : TestCase(){

@Test
fun testD3p2() {
    val testPath = "src/testInputFiles/day3.txt"
    val testinput = readFileLns(testPath)
    val expected = "10111o 01010c"
    TestCase.assertEquals(expected, part2(testinput))
}
}

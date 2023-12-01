import days.firstLastDigits
import days.firstLastDigits2
import junit.framework.TestCase

class Day1KtTest : TestCase() {
    val input = """ 
1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet
    """.trimIndent().lines()

    fun testDay1() {
        val ans = firstLastDigits(input)
        assertEquals(142, ans)
    }

    val input2 = """
    two1nine
    eightwothree
    abcone2threexyz
    xtwone3four
    4nineeightseven2
    zoneight234
    7pqrstsixteen
""".trimIndent().lines()

    fun testDay2() {
        val ans = firstLastDigits2(input2)
        assertEquals(281, ans)
    }
}

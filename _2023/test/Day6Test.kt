import days.chargeVsSpeedRace
import days.chargeVsSpeedRace2
import junit.framework.TestCase

class Day6KtTest : TestCase() {
    val input = """
        Time:      7  15   30
        Distance:  9  40  200
    """.trimIndent().lines()

    fun test1Day0() {
        val ans = chargeVsSpeedRace(input)
        assertEquals(288, ans)
    }
    fun test2Day0() {
        val ans = chargeVsSpeedRace2(input)
        assertEquals(71503, ans)
    }
}

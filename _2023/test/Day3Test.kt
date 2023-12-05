import days.numbersConnectedToSymbol
import days.starWith2Numbers
import junit.framework.TestCase

class Day3KtTest : TestCase() {
    val input = """
        467..114..
        ...*......
        ..35..633.
        ......#...
        617*......
        .....+.58.
        ..592.....
        ......755.
        ...${'$'}.*....
        .664.598..
    """.trimIndent().lines()

    fun test1Day3() {
        val ans = numbersConnectedToSymbol(input)
        assertEquals(4361, ans)
    }

    fun test2Day3() {
        val ans = starWith2Numbers(input)
        assertEquals(467835, ans)
    }
}

import days.circumferenceAndArea
import junit.framework.TestCase

class Day10KtTest : TestCase() {
    val input = """
        ..F7.
        .FJ|.
        SJ.L7
        |F--J
        LJ...
    """.trimIndent().lines()
    val input2 = """
...........
.S-------7.
.|F-----7|.
.||.....||.
.||.....||.
.|L-7.F-J|.
.|..|.|..|.
.L--J.L--J.
...........
    """.trimIndent().lines()

    fun test1Day10() {
        val ans2 = circumferenceAndArea(input)
        assertEquals(8, ans2)
    }

    fun test2Day10() {
       circumferenceAndArea(input2)
    }
}

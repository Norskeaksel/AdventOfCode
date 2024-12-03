import days.day15
//import days.day152
import junit.framework.TestCase

class Day15KtTest : TestCase() {
    val input = """
        rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7
    """.trimIndent().lines()

    fun test1Day15() {
        val ans = day15(input)
        assertEquals(1320, ans)
    }
    /*fun test2Day15() {
        val ans = day152(input)
        assertEquals(145, ans)
    }*/
}

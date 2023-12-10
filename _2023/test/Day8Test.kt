import days.rightLeftSteps
import days.rightLeftSteps2
import junit.framework.TestCase

class Day8KtTest : TestCase() {
    val input = """
        RL

        AAA = (BBB, CCC)
        BBB = (DDD, EEE)
        CCC = (ZZZ, GGG)
        DDD = (DDD, DDD)
        EEE = (EEE, EEE)
        GGG = (GGG, GGG)
        ZZZ = (ZZZ, ZZZ)
    """.trimIndent().lines()

    val input2 = """
LLR

AAA = (BBB, BBB)
BBB = (AAA, ZZZ)
ZZZ = (ZZZ, ZZZ)
    """.trimIndent().lines()

    fun test1day8() {
        val ans = rightLeftSteps(input)
        assertEquals(2, ans)
        val ans2 = rightLeftSteps(input2)
        assertEquals(6, ans2)
    }

    val input3 = """
        LR

        11A = (11B, XXX)
        11B = (XXX, 11Z)
        11Z = (11B, XXX)
        22A = (22B, XXX)
        22B = (22C, 22C)
        22C = (22Z, 22Z)
        22Z = (22B, 22B)
        XXX = (XXX, XXX)
    """.trimIndent().lines()
    fun test2day8() {
        val ans = rightLeftSteps2(input3)
        assertEquals(6, ans)
    }
}

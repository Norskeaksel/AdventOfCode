import junit.framework.TestCase

class Day1KtTest: TestCase(){
    val input = """
        1721
        979
        366
        299
        675
        1456
    """.trimIndent().lines()

    fun `test sumsTo2020`(){
        val c = sumsPairTo2020(input)
        assert(c[0]+c[1] == 2020L)
    }
}

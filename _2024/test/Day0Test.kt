import junit.framework.TestCase

class Day0Test : TestCase() {
    val input = """
    """.trimIndent().lines()

    fun test1() {
        val ans = day0a(input)
        assertEquals(0, ans)
    }
    fun test2() {
        val ans = day0b(input)
        assertEquals(0, ans)
    }
}

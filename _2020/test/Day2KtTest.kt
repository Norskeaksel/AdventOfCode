import junit.framework.TestCase

class Day2KtTest: TestCase(){
    val input = """
        1-3 a: abcde
        1-3 b: cdefg
        2-9 c: ccccccccc
    """.trimIndent().lines()
    fun testValidPasswords(){
        val ans = validPasswords(input, ::isValidLine1)
        assertEquals(2, ans)
    }
    fun testValidPasswords2(){
        val ans = validPasswords(input, ::isValidLine2)
        assertEquals(1, ans)
    }
}

import days.day10a
import days.day10b
import junit.framework.TestCase

class Day10Test : TestCase() {
    val input = """
        89010123
        78121874
        87430965
        96549874
        45678903
        32019012
        01329801
        10456732
    """.trimIndent().lines()
    val exa = """
...0...
...1...
...2...
6543456
7.....7
8.....8
9.....9
    """.trimIndent().lines()

    val exb = """
        ..90..9
        ...1.98
        ...2..7
        6543456
        765.987
        876....
        987....
    """.trimIndent().lines()

    val ex2a = """
        .....0.
        ..4321.
        ..5..2.
        ..6543.
        ..7..4.
        ..8765.
        ..9....
    """.trimIndent().lines()

    val ex2b = """
        ..90..9
        ...1.98
        ...2..7
        6543456
        765.987
        876....
        987....
    """.trimIndent().lines()

    fun test1a(){
        val ans = day10a(exa)
        assertEquals(2, ans)
    }
    fun test1b(){
        val ans = day10a(exb)
        assertEquals(4, ans)
    }

    fun test1() {
        val ans = day10a(input)
        assertEquals(36, ans)
    }
    fun test2a(){
        val ans = day10b(ex2a)
        assertEquals(3, ans)
    }
    fun test2b(){
        val ans = day10b(ex2b)
        assertEquals(13, ans)
    }
    fun test2() {
        val ans = day10b(input)
        assertEquals(81, ans)
    }
}

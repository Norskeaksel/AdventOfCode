import days.day5a
import days.day5b
import junit.framework.TestCase

class Day5Test : TestCase() {
    val input = """
        47|53
        97|13
        97|61
        97|47
        75|29
        61|13
        75|53
        29|13
        97|29
        53|29
        61|53
        97|53
        61|29
        47|13
        75|47
        97|75
        47|61
        75|61
        47|29
        75|13
        53|13

        75,47,61,53,29
        97,61,53,29,13
        75,29,13
        75,97,47,61,53
        61,13,29
        97,13,75,29,47
    """.trimIndent().lines()

    fun test1() {
        val ans = day5a(input)
        assertEquals(143, ans)
    }
    fun test2() {
        val ans = day5b(input)
        assertEquals(123, ans)
    }
}

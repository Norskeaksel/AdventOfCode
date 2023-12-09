package days

enum class Rank {
    Five,
    Four,
    House,
    TwoPairs,
    Pair,
    HighCard
}

data class Play(val hand: String, private val bidString: String) : Comparable<Play> {
    val bid = bidString.toInt()
    val rank = findRank(hand)

    private fun findRank(hand: String): Int {
        val handSorted = hand.toCharArray().sorted().joinToString("")
        val handSplit = handSorted.split("""(?<=(.))(?!\\1)""".toRegex())
        val cardStreak = handSplit.sortedByDescending { it.length }.map { it.length }
        when {
            cardStreak[0] == 5 -> return 7
            cardStreak[0] == 4 -> return 6
            cardStreak[0] == 3 && cardStreak[1] == 2 -> return 5
            cardStreak[0] == 3 -> return 4
            cardStreak[0] == 2 && cardStreak[1] == 2 -> return 3
            cardStreak[0] == 2 -> return 2
            else -> return 1
        }
    }

    override operator fun compareTo(other: Play) = compareValuesBy(this, other,
        {it.rank},
        {it.bidString} // TODO Compare this correctly
    )
}

fun day7(input: List<String>): Int {
    val plays = mutableListOf<Play>()
    input.forEach { line ->
        val (hand, bid) = line.split(" ")
        plays.add(Play(hand, bid))
    }
    return 0
}

fun day72(input: List<String>): Int {
    input.forEach { line ->

    }
    return 0
}

fun main() {
    val input = readFileLines("_2023/inputFiles/Day0")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day7(input))
    println(day72(input))
}


package days


class Play(rawHand: String, bidString: String, part2:Boolean=false) : Comparable<Play> {
    val bid = bidString.toInt()
    var hand = rawHand
    var mimicHand = hand

    init {
        val remap = mapOf('T' to 'B', 'J' to if(part2) '1' else 'C', 'Q' to 'D', 'K' to 'E', 'A' to 'F')
        for (i in remap) {
            hand = hand.replace(i.key, i.value)
        }
        if(part2){
            val strength = hand
                .toCharArray()
                .associateWith { c -> hand.count{it == c} }.toMutableMap()
            strength['1'] = 0
            val majorityThreshold = strength.values.max()
            val majorityChars = strength.keys.filter { key -> strength[key] == majorityThreshold }
            val mimicTarget = majorityChars.maxOf { it }
            mimicHand = hand.replace('1', mimicTarget)
        }
    }

    val rank = findRank(mimicHand)

    private fun findRank(hand: String): Int {
        val chars = hand.toCharArray()
        val strength = chars.associateWith { c -> hand.count { it == c } }
        val values = strength.values
        return when {
            strength.size == 1 ->  7
            strength.size == 2 && values.max() == 4 -> 6
            strength.size == 2 ->  5
            strength.size == 3 && values.max() == 3 ->  4
            strength.size == 3 -> 3
            strength.size == 4 ->  2
            else -> return 1
        }
    }


    override operator fun compareTo(other: Play) = compareValuesBy(this, other,
        { it.rank },
        { it.hand }
    )
}

fun day7(input: List<String>): Long {
    val plays = mutableListOf<Play>()
    input.forEach { line ->
        val (hand, bid) = line.split(" ")
        plays.add(Play(hand, bid))
    }
    plays.sort()
    var winnings = 0L
    plays.forEachIndexed { i, play ->
        winnings += play.bid * (i + 1)
    }
    return winnings
}

fun day72(input: List<String>): Long {
    val plays = mutableListOf<Play>()
    input.forEach { line ->
        val (hand, bid) = line.split(" ")
        plays.add(Play(hand, bid, true))
    }
    plays.sort()
    var winnings = 0L
    plays.forEachIndexed { i, play ->
        winnings += play.bid * (i + 1)
    }
    return winnings
}

fun main() {
    val input = readFileLines("_2023/inputFiles/Day7")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day7(input))
    println(day72(input))
}


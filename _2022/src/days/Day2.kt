import days.readFileLines

val rock = 1
val paper = 2
val scissors = 3
val lose = 0
val draw = 3
val win = 6
fun rockPaper1(input: List<String>): Int {
    var ans = 0
    input.forEach {
        when (it[0]) {
            'A' -> when (it[2]) {
                'X' -> ans += rock + draw
                'Y' -> ans += paper + win
                'Z' -> ans += scissors + lose
            }

            'B' -> when (it[2]) {
                'X' -> ans += rock + lose
                'Y' -> ans += paper + draw
                'Z' -> ans += scissors + win
            }

            'C' -> when (it[2]) {
                'X' -> ans += rock + win
                'Y' -> ans += paper + lose
                'Z' -> ans += scissors + draw
            }
        }
    }
    return ans
}

fun rockPaper2(input: List<String>): Int {
    var ans = 0
    input.forEach {
        when (it[0]) {
            'A' -> when (it[2]) {
                'X' -> ans += lose + scissors
                'Y' -> ans += draw + rock
                'Z' -> ans += win + paper
            }

            'B' -> when (it[2]) {
                'X' -> ans += lose + rock
                'Y' -> ans += draw + paper
                'Z' -> ans += win + scissors
            }

            'C' -> when (it[2]) {
                'X' -> ans += lose + paper
                'Y' -> ans += draw + scissors
                'Z' -> ans += win + rock
            }
        }
    }
    return ans
}

fun main() {
    val input = readFileLines("src/main/kotlin/Day")
    println(rockPaper1(input))
    println(rockPaper2(input))
}

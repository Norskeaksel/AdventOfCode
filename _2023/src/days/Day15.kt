package days

fun day15(input: List<String>): Long {
    val line = input[0]
    val strings = line.split(",")
    var ans = 0L
    strings.forEach { string ->
        val current = hash(string)
        ans += current
    }
    return ans
}

private fun hash(string: String): Long {
    var current = 0L
    string.forEach { c ->
        current += c.code
        current *= 17
        current %= 256
    }
    return current
}

/*fun day152(input: List<String>): Int {
    val boxes = mutableMapOf<Long, MutableList<Pair<String, Int>>>()
    val line = input[0]
    val label = line.split("-", "=").first()
    val box = hash(label)
    if ('-' in line) {
        boxes[box]?.let { content ->
            content.forEach {
                if (it.first == label) {
                    content.remove(it)
                }
            }
        }
    } else {
        val (label, focus) = line.split("=")
        boxes[box]?.add(Pair(label,focus.toInt()))
    }
    val operationRemove = line.split("-")
    val operationAddOrReplace = line.split()

    return 0
}*/

fun main() {
    val input = readFileLines("_2023/inputFiles/Day15")
    require(input.isNotEmpty()) { "Input file must not be empty" }
    println(day15(input))
    //println(day152(input))
}


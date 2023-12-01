package days

fun extracted(ansSet: Set<Char>): Int {
    var ans1 = 0
    ansSet.forEach {
        if (it.isLowerCase()) {
            ans1 += it - 'a' + 1
        } else {
            ans1 += it - 'A' + 27
        }
    }
    return ans1
}

fun findCompleatIntevalOverlap(input: List<String>): Int {
    var ans = 0
    input.forEach {
        val ansSet = mutableSetOf<Char>()
        val left = it.substring(0, it.length / 2)
        val right = it.substring(it.length / 2, it.length)
        val leftSet = mutableSetOf<Char>()
        leftSet.addAll(left.toList())
        val rightSet = mutableSetOf<Char>()
        right.forEach {
            if (leftSet.contains(it)) {
                ansSet.add(it)
            }
        }
        ans += extracted(ansSet)
    }
    return ans
}

fun findOverlappingInterval(input: List<String>): Int {
    var ans = 0
    var ansSet: Set<Char>
    val group = mutableListOf<String>()
    assert(input[3]=="")
    assert(input[input.size-1]=="")
    input.forEach {
        if (it == "") {
            val a = group[0].toList()
            val b = group[1].toList()
            val c = group[2].toList()
            ansSet = (a.intersect(b).intersect(c))
            ans += extracted(ansSet)
            group.clear()
        } else {
            group.add(it)
        }
    }
    return ans
}

fun main() {
    val input = readFileLines("src/main/kotlin/Day")
    println(findCompleatIntevalOverlap(input))
    println(findOverlappingInterval(input))
}

/*import java.io.File

fun part1(input: List<Int>, days: Int):Int  {
    val fish: MutableList<Byte> = input.map { it.toByte() }.toMutableList()
    for (k in 0 until days) {
        println("After $k days there are ${fish.size} fish")
        fish.replaceAll { (it - 1).toByte() }
        for (i in 0 until fish.size) {
            if (fish[i] < 0) {
                fish[i] = 6
                fish.add(8)
            }
        }
    }
    return fish.size
}
fun part2(input: List<Int>, days: Int): Long {
    val fish: MutableList<Byte> = input.map { it.toByte() }.toSet().toMutableList()
    var types = mutableMapOf<Byte, Int>()
    for(f in fish) {
        types.putIfAbsent(f, 0)
        types[f] = types[f]!! + 1
    }

    for (k in 0 until days) {
        println("After $k days: ${fish.size}")
        val fs = fish.size.toString()+"\n"
        File("fish.txt").appendText(fs, Charsets.UTF_8)
        fish.replaceAll { (it - 1).toByte() }
        for (i in 0 until fish.size) {
            if (fish[i] < 0) {
                fish[i] = 6
                fish.add(8)
            }
        }
    }
    return fish.size.toLong()
}

fun main(args: Array<String>) {
    val path = "src/inputFiles/day6.txt"
    val input = readFileIntLns(path)
    val ans1 = part1(input, 80 )
    println("Part 1 = $ans1")
    val ans2 = part1(input,256)
    println("Part 2 = $ans2")
}*/

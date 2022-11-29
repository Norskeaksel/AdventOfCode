/*fun part1(){
    var depth = 0
    var distance = 0
}*/

fun part1(input:List<String>):Int{
    var depth = 0
    var distance = 0
    for(line in input){
        val words = line.split(" ")
        val direction = words[0]
        val movement = words[1].toInt()
        when(direction){
            "forward" ->distance+=movement
            "up" -> depth -= movement
            "down" -> depth += movement
        }
    }
    return depth*distance
}

fun part2(input:List<String>):Int{
    var depth = 0
    var distance = 0
    var aim = 0
    for(line in input){
        val words = line.split(" ")
        val direction = words[0]
        val movement = words[1].toInt()
        when(direction){
            "forward" ->{
              distance+=movement
              depth += aim*movement
            }
            "up" -> aim -= movement
            "down" -> aim += movement
        }
    }
    return depth*distance
}


fun main(args: Array<String>) {
    val path = "src/inputFiles/d2p1.txt"
    val input = readFileLns(path)
    val ans1 = part1(input)
    println("Part 1 = $ans1")
    val ans2 = part2(input)
    println("Part 2 = $ans2")
}

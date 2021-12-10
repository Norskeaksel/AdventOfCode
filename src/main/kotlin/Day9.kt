fun Boolean.toInt() = if (this) 1 else 0

fun _isLowPoint(input:List<String>, x:Int, y: Int, height:Int, width:Int): Boolean{
    for (i in 0..3) { //non diagonal
        val nx: Int = x + (i == 0).toInt() - (i == 1).toInt()
        val ny: Int = y + (i == 2).toInt() - (i == 3).toInt()
        if(nx>=0 && nx<width && ny>=0 && ny<height){
            if(input[ny][nx]<=input[y][x])
                return false
        }
    }
    return true
}

fun part1(input: List<String>): Int {
    var score = 0
    val height = input.size
    val width = input[0].length
    for(y in 0 until height){
        for(x in 0 until width){
            //print(input[y][x])
            if(_isLowPoint(input,x,y,height, width)){
                //println(input[y][x])
                val pointRisk = input[y][x] - '0' + 1
                score+= pointRisk
            }
        }
    }
    return score
}


fun part2(input: List<String>): Int {
    return -1
}


fun main(args: Array<String>) {
    val path = "src/inputFiles/day9.txt"
    val input = readLineByLine(path)
    println("h=${input.size} w=${input[0].length}")
    val ans1 = part1(input)
    println("Part 1 = $ans1")
    val ans2 = part2(input)
    println("Part 2 = $ans2")
}

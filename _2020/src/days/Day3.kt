package days

fun countTrees(input:List<String>, xStep:Int=3, yStep:Int=1):Int{
    val height = input.size
    val width = input[0].length
    val ans = input.indices.count{it%yStep==0 && input[it][it/yStep*xStep % width] == '#' }
    return ans
}

fun countTrees2(input:List<String>):Long{
    val xSlopes = listOf(1,3,5,7)
    return xSlopes.map{ countTrees(input, it).toLong() }.reduce { acc, l -> acc*l } * countTrees(input,1,2)
}

fun main(){
    val input = readFileLines("_2020/src/inputFiles/Day3")
    println(countTrees(input))
    println(countTrees2(input))
}

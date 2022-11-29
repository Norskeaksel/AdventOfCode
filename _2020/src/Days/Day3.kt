package Days

import java.math.BigInteger

fun countTrees(input:List<String>, xStep:Int=3, yStep:Int=1):Int{
    val height = input.size
    val width = input[0].length
    val ans = input.indices.count{it%yStep==0 && input[it][it/yStep*xStep % width] == '#' }
    /*var ans = 0
    for(i in 0 until height step yStep){
        ans += (input[i][x] == '#').toInt()
        x+=xStep
        if (x>=width)
            x-=width
    }*/
    return ans
}

fun countTrees2(input:List<String>):Long{
    val xSlopes = listOf(1,3,5,7)
    /*var ans = 1L
    xSlopes.forEach{
        ans*= countTrees(input, it)
        if(it==1)
            ans*= countTrees(input,1,2)
    }
    return ans*/
    return xSlopes.map{ countTrees(input, it).toLong() }.reduce { acc, l -> acc*l } * countTrees(input,1,2)
}

fun main(){
    val input = readFileLines("_2020/src/inputFiles/Day3")
    println(countTrees(input))
    println(countTrees2(input))
}

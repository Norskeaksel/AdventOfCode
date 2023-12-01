import days.readFileLines
import java.util.Collections.emptyList

fun sumsPairTo2020(input: List<String>): List<Long>{
    val numbers = input.map { it.toLong() }
    for (i in numbers.indices) {
        for (j in i+1 until numbers.size) {
            if (numbers[i] + numbers[j] == 2020L) {
                return listOf(numbers[i], numbers[j])
            }
        }
    }
    return emptyList()
}

fun sumsTripleTo2020(input: List<String>): List<Long>{
    val n = input.map { it.toLong() }
    for(i in n.indices){
        for(j in i+1 until n.size){
            for(k in j+1 until n.size){
                val candidtes = n.slice(listOf(i,j,k))
                if(candidtes.sum()==2020L)
                    return candidtes
            }
        }
    }
    return emptyList()
}

fun main(){
    val input = readFileLines("_2020/src/inputFiles/Day1")
    println(sumsPairTo2020(input).reduce{product, i -> product*i})
    println(sumsTripleTo2020(input).reduce{product, i -> product*i})
}

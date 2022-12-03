package Days

fun part1(input: List<String>): String {
    val bits = input[0].length
    var gamma = ""
    var epsilon = ""
    for (i in 0 until bits) {
        var ones = 0
        var zeroes = 0
        for (line in input) {
            if (line[i] == '1')
                ones++
            else
                zeroes++
        }
        if (ones > zeroes) {
            gamma += '1'
            epsilon += '0'
        } else {
            epsilon += '1'
            gamma += '0'
        }
    }
    return gamma + "g " + epsilon + 'e'
}

fun _reduceInput(input: List<String>, wantCommonBits: Int): String {
    var output = input.toMutableList()
    val bits = input[0].length
     for(i in 0 until bits){
         val oneLiners = mutableListOf<String>()
         val zeroLiners = mutableListOf<String>()
         //println(output)
         if(output.size<2)
             break
        for (line in output) {
             if (line[i] == '1')
                oneLiners.add(line)
            else
                zeroLiners.add(line)
        }
         if(wantCommonBits==1){
        //if(oneLiners.size*wantCommonBits>=zeroLiners.size*wantCommonBits)
             if(oneLiners.size>=zeroLiners.size)
                output=oneLiners
            else
                output=zeroLiners
         }
             else
                 if(oneLiners.size<zeroLiners.size)
                     output=oneLiners
                 else
                     output=zeroLiners


    }
    return output[0]
}

fun part2(input: List<String>): String {
    val oxygenRating = _reduceInput(input, 1)
    val CO2rating = _reduceInput(input,-1)
    return oxygenRating+"o "+CO2rating+"c"
}


fun main(args: Array<String>) {
    val path = "src/inputFiles/day3.txt"
    val input = readFileLns(path)
    val ans1 = part1(input)
    println("Part 1 = $ans1")
    val ans2 = part2(input)
    println("Part 2 = $ans2")
}

import days.readFileLines
import days.toInt

data class Input(val min:Int, val max:Int, val letter:Char, val password:String)
fun splitInput(line:String): Input {
    val (a,b) = line.split("-", " ").run {
        Pair(this[0].toInt(), this[1].toInt())
    }
    val (letter, password) = line.split(": ").run{
        Pair(this[0].last(), this[1])
    }
    return Input(a,b,letter,password)
}
fun validPasswords(input:List<String>, isValidLine:(input:String) -> Boolean): Int {
    var c = 0
    input.forEach(){
        c+= isValidLine(it).toInt()
    }
    return c
}
fun isValidLine1(line:String):Boolean {
    val(min,max,letter,password) = splitInput(line)
    val count = password.count{it == letter}
    return count in min..max
}

fun String.indexIfExist(i:Int) = if(this.length<=i) "" else this[i]
fun isValidLine2(line: String):Boolean{
    val(a,b,letter,password) = splitInput(line)
    return (password.indexIfExist(a-1) == letter) xor (password.indexIfExist(b-1) == letter)
}

fun main() {
    val input = readFileLines("_2020/src/inputFiles/Day2")
    println(validPasswords(input, ::isValidLine1))
    println(validPasswords(input, ::isValidLine2))
}


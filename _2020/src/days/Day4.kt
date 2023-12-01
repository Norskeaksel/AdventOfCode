package days

fun passportHasFields(line: String): Boolean {
    val fields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
    fields.forEach() {
        if (it !in line) {
            return false
        }
    }
    return true
}

fun countPassport(input: String): Int {
    val passports = input.split("\n\n")
    return passports.count { passportHasFields(it) }
}

fun passToMap(passport: String): Map<String, String> {
    val keyValuePairs = passport.split(" ", "\n")
    val myMap = keyValuePairs.associate {
        val (key, value) = it.split(":")
        key to value
    }
    return myMap
}

fun countPassport2(input: String): Int {
    val passports = input.split("\n\n")
    val validPassports = mutableListOf<String>()
    passports.forEach {
        if (passportHasFields(it)) {
            validPassports.add(it)
        }
    }
    var ans = 0
    validPassports.forEach() {
        val myMap = passToMap(it)
        val isValid = myMap.all { (key, value) ->
            when (key) {
                "byr" -> value.toIntOrNull() in 1920..2002
                "iyr" -> value.toIntOrNull() in 2010..2020
                "eyr" -> value.toIntOrNull() in 2020..2030
                "hcl" -> value matches """#[0-9a-f]{6}""".toRegex()
                "ecl" -> value in setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
                "pid" -> value.length == 9 && value.all(Char::isDigit)
                "hgt" -> {
                    if (value.contains("cm")) {
                        (value.length == 5 && value.substring(0, 3).toIntOrNull() in 150..193)
                    } else if (value.contains("in")) {
                        (value.length == 4 && value.substring(0, 2).toInt() in 59..76)
                    } else false
                }
                else -> true
            }
        }
        if(isValid)
            ans++
    }
    return ans
}

fun main() {
    val input = readFile("_2020/src/inputFiles/Day4")
    println(countPassport(input))
    println(countPassport2(input))
}

package day2

import java.util.stream.Collectors

class Day2(private val values: MutableList<String>) {

    fun solve(): Int {

        return values.fold(0, { acc, s ->

            val policy = PasswordPolicy(s.split(":")[0])
            val password = s.split(":")[1].trim()

            val isValid = policy.isValidPart1(password)


            if (isValid) {
                acc + 1
            } else {
                acc
            }
        })
    }

    fun solvePart2(): Int {
        return values.fold(0, { acc, s ->

            val policy = PasswordPolicy(s.split(":")[0])
            val password = s.split(":")[1].trim()

            val isValid = policy.isValidPart2(password)


            if (isValid) {
                acc + 1
            } else {
                acc
            }
        })
    }

    class PasswordPolicy(policyString: String) {
        private val minTimes: Int = policyString.split("-")[0].toInt()
        private val maxTimes: Int = policyString.split("-")[1].split(" ")[0].toInt()
        private val reqLetter: Char = policyString.split(" ")[1][0]

        fun isValidPart1(password: String): Boolean {

             return password.filter { it == reqLetter }.length in minTimes..maxTimes

        }

        fun isValidPart2(password: String): Boolean {

            return 1 == password.foldIndexed(0, { index, acc, c ->
            if (index +1 == minTimes || index +1 == maxTimes ){
                if (c == reqLetter){
                    return@foldIndexed acc +1
                } else{
                    return@foldIndexed acc
                }
            }
                return@foldIndexed acc
            })

        }

    }


}

fun main() {
    val problem = Day2::class.java.getResource("day2.txt")
        .readText()
        .split("\n")
        .stream()
        .collect(Collectors.toList())

    println(Day2(problem).solve())
    println(Day2(problem).solvePart2())
}
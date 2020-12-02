package day1

import java.util.stream.Collectors

class Day1(private var values: List<Int>) {

    fun solve(): Int {
        for (outer in values) {
            for (inner in values) {
                if (outer + inner == 2020) {
                    return outer * inner
                }
            }
        }
        return 0
    }

    fun solvePart2(): Int {
        for (outer in values) {
            for (inner in values) {
                for (innerInner in values) {
                    if (outer + inner + innerInner == 2020) {
                        return outer * inner * innerInner
                    }
                }
            }
        }
        return 0
    }

}

fun main() {
    val problem = Day1::class.java.getResource("day1.txt")
        .readText()
        .split("\r\n")
        .stream()
        .map { it.toInt() }
        .collect(Collectors.toList())

    println(Day1(problem).solve())
    println(Day1(problem).solvePart2())
}
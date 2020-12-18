package day3

import java.util.stream.Collectors

class Day3(private val values: List<String>) {
    fun solve(): Int {
        return values.foldIndexed(0, { index, acc, s ->
            acc + lookUp(index * 3, index)
        })
    }

    fun solvePart2(): Int {
        val results = mutableListOf<Int>()
        results.add(values.foldIndexed(0, { index, acc, s ->
            acc + lookUp(index, index)
        }))

        results.add(values.foldIndexed(0, { index, acc, s ->
            acc + lookUp(index * 3, index)
        }))

        results.add(values.foldIndexed(0, { index, acc, s ->
            acc + lookUp(index * 5, index)
        }))

        results.add(values.foldIndexed(0, { index, acc, s ->
            acc + lookUp(index * 7, index)
        }))

        results.add(values.foldIndexed(0, { index, acc, s ->
            acc + lookUp(index, index * 2)
        }))

        results.forEach { println(it) }

        return results.fold(1, { acc, i -> acc * i })
    }

    private fun lookUp(x: Int, y: Int): Int {
        if (x == 0) {
            return 0
        }
        if (y > values.size){
            return 0
        }

        println("$x, $y ${x % values[y].length}, $y")


        return if (values[y][x % values[y].length] == '#') {
            1
        } else {
            0
        }
    }
}

fun main() {
    val problem = Day3::class.java.getResource("day3.txt")
        .readText()
        .split("\n")
        .stream()
        .collect(Collectors.toList())

    println(Day3(problem).solve())
    println(Day3(problem).solvePart2())
}
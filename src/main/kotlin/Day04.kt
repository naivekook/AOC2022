fun main() {
    val input = readInput("input_day04")

    input
        .map { line ->
            line
                .split(",")
                .map { sections ->
                    sections
                        .split("-")
                        .let { it[0].toInt() to it[1].toInt() }
                }
                .let {
                    it[0] to it[1]
                }
            // list of pairs of pairs like [ ((5, 96), (6, 99)), ... ]
        }
        .map {
            when {
                // part 1
//                it.first.first >= it.second.first && it.first.second <= it.second.second -> 1
//                it.second.first >= it.first.first && it.second.second <= it.first.second -> 1

                // part 2
                it.first.first >= it.second.first && it.first.first <= it.second.second -> 1
                it.second.first >= it.first.first && it.second.first <= it.first.second -> 1
                else -> 0
            }
        }
        .sum()
        .let {
            println(it)
        }
}
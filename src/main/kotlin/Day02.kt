import HandShape.*

fun main() {
    val input = readInput("input_day02")

    val total = input
        .map { strategy ->
            strategy.split(" ").let { Pair(it[0], it[1]) }
        }
        .map {
            // part 1
//            Round(parseHandShape(it.first), parseHandShape(it.second))

            // part 2
            parseRound(it)
        }
        .sumOf { round ->
            round.calculateScore()
        }

    println(total)
}

private enum class HandShape {
    Rock, Paper, Scissors;
}

private data class Round(val elf: HandShape, val player: HandShape)

private fun parseHandShape(code: String): HandShape = when (code) {
    "A", "X" -> Rock
    "B", "Y" -> Paper
    "C", "Z" -> Scissors
    else -> throw IllegalStateException()
}

private fun parseRound(codes: Pair<String, String>): Round {
    val elfShape = parseHandShape(codes.first)
    val playerShape = when (codes.second) {
        "X" -> {
            when (elfShape) {
                Rock -> Scissors
                Paper -> Rock
                Scissors -> Paper
            }
        }

        "Y" -> elfShape
        "Z" -> {
            when (elfShape) {
                Rock -> Paper
                Paper -> Scissors
                Scissors -> Rock
            }
        }

        else -> throw IllegalStateException()
    }
    return Round(elfShape, playerShape)
}

private fun Round.calculateScore(): Int {
    val shapeScore = when (player) {
        Rock -> 1
        Paper -> 2
        Scissors -> 3
    }
    val roundScore = when {
        player == elf -> 3
        player == Rock && elf == Scissors -> 6
        player == Paper && elf == Rock -> 6
        player == Scissors && elf == Paper -> 6
        else -> 0
    }
    return shapeScore + roundScore
}
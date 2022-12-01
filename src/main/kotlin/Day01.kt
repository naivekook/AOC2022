fun main() {
    val input = readInput("input_day01")
    println("Puzzle input: $input\n")

    val caloriesList = mutableListOf<Int>()
    var calories = 0
    input.forEach { s ->
        if (s.isBlank()) {
            caloriesList.add(calories)
            calories = 0
        } else {
            calories += s.toInt()
        }
    }

    // part 1
    println(caloriesList.max())

    // part 2
    println( caloriesList.sortedDescending().take(3).sum())
}
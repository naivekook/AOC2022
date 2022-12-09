fun main() {
    val input = readInput("input_day06")

    // part 1
    println(findMarker(input.first(), 4))

    // part 2
    println(findMarker(input.first(), 14))
}

private fun findMarker(input: String, distinctCharacters: Int): Int {
    var i = 0
    var j = distinctCharacters
    while (j < input.length) {
        if (input.substring(i, j).toSet().size == distinctCharacters) {
            return j
        } else {
            i++
            j++
        }
    }
    return 0
}
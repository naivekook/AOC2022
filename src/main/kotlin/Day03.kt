fun main() {
    val input = readInput("input_day03")

    // part 1
    input
        .map { rucksacks ->
            rucksacks.chunked(rucksacks.length / 2)
        }
        .map { compartments ->
            compartments[0].toList().intersect(compartments[1].toSet())
        }
        .sumOf { items ->
            items.sumOf { it.priority() }
        }
        .let {
            println(it)
        }

    // part 2
    input
        .chunked(3)
        .mapNotNull { group ->
            findCommonItem(group)
        }
        .sumOf {
            it.priority()
        }
        .let {
            println(it)
        }
}

private fun findCommonItem(group: List<String>): Char? {
    val map = mutableMapOf<Char, Int>()
    group.forEach { rucksack ->
        rucksack
            .toSet()
            .forEach { char ->
                if (map.containsKey(char)) {
                    map[char] = map.getOrDefault(char, 0) + 1
                    if (map[char] == group.size) {
                        return char
                    }
                } else {
                    map[char] = 1
                }
            }
    }
    return null
}

private fun Char.priority(): Int {
    return alphabets.indexOf(this) + 1
}

private val alphabets = ('a'..'z').toList() + ('A'..'Z').toList()
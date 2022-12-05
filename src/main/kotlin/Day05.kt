fun main() {
    val input = readInput("input_day05")

    val commands = input
        .map { commandStr ->
            commandStr.split(" ")
        }
        .map { parts ->
            Command(parts[1].toInt(), parts[3].toInt(), parts[5].toInt())
        }

    // part 1
//    commands.forEach { command ->
//        for (i in 0 until command.amount) {
//            val item = stacks[command.from - 1].removeLast()
//            stacks[command.to - 1].add(item)
//        }
//    }

    // part 2
    commands.forEach { command ->
        val items = stacks[command.from - 1].takeLast(command.amount)
        stacks[command.from - 1] = stacks[command.from - 1].dropLast(command.amount).toMutableList()
        stacks[command.to - 1].addAll(items)
    }

    stacks
        .map {
            it.last()
        }
        .joinToString("")
        .let {
            println(it)
        }
}

private data class Command(val amount: Int, val from: Int, val to: Int)

private val stacks = mutableListOf(
    mutableListOf('N', 'C', 'R', 'T', 'M', 'Z', 'P'),
    mutableListOf('D', 'N', 'T', 'S', 'B', 'Z'),
    mutableListOf('M', 'H', 'Q', 'R', 'F', 'C', 'T', 'G'),
    mutableListOf('G', 'R', 'Z'),
    mutableListOf('Z', 'N', 'R', 'H'),
    mutableListOf('F', 'H', 'S', 'W', 'P', 'Z', 'L', 'D'),
    mutableListOf('W', 'D', 'Z', 'R', 'C', 'G', 'M'),
    mutableListOf('S', 'J', 'F', 'L', 'H', 'W', 'Z', 'Q'),
    mutableListOf('S', 'Q', 'P', 'W', 'N'),
)
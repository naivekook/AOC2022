fun main() {
    val input = readInput("input_day07")
        .map { it.replace("$ ", "") }
        .filter { it != "ls" }

    val root = Node("/", null)
    var current = root
    input.forEach { line ->
        val (command, args) = line.split(" ")
        when (command) {
            "cd" -> {
                current = when (args) {
                    "/" -> root
                    ".." -> current.parent!!
                    else -> current.children.first { it.name == args }
                }
            }

            "dir" -> current.children.add(Node(args, current))
            else -> current.size += command.toInt()
        }
    }

    val sizes = mutableListOf<Int>()
    recursiveSizes(root, sizes)

    // part 1
    println(sizes.filter { it <= 100_000 }.sum())

    // part 2
    val needed = 30_000_000 - (70_000_000 - sizes.max())
    println(sizes.filter { it >= needed }.min())
}

private fun recursiveSizes(node: Node, sizes: MutableList<Int>): Int {
    val size = node.size + node.children.sumOf { recursiveSizes(it, sizes) }
    sizes.add(size)
    return size
}

private data class Node(val name: String, val parent: Node?) {
    var size: Int = 0
    val children: MutableList<Node> = mutableListOf()
}

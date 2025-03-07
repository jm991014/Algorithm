private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val node = br.readLine().toInt()
    val graph = Array(node + 1) { mutableListOf<Int>() }
    val parent = IntArray(node + 1)
    repeat(node - 1) {
        val (from, to) = br.readLine().split(" ").map { it.toInt() }
        graph[from].add(to)
        graph[to].add(from)
    }
    dfs(node, graph, parent)
    parent.filter { it != 0 }.forEach { write("$it\n") }
    close()
}

fun dfs(node: Int, graph: Array<MutableList<Int>>, parent: IntArray) {
    val stack = ArrayDeque<Int>().apply { add(1) }
    val visited = BooleanArray(node + 1).apply { this[1] = true }

    while (stack.isNotEmpty()) {
        val cur = stack.removeLast()
        for (i in graph[cur]) {
            if (!visited[i]) {
                visited[i] = true
                stack.add(i)
                parent[i] = cur
            }
        }
    }
}
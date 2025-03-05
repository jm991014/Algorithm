private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (node, edge) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(node + 1) { IntArray(node + 1) }
    val visited = BooleanArray(node + 1)
    var connection = 0

    repeat(edge) {
        val (from, to) = br.readLine().split(" ").map { it.toInt() }
        graph[from][to] = 1
        graph[to][from] = 1
    }

    for (i in 1 until graph.size) {
        if (graph[i].all { it == 0 }) connection++
        for (j in graph[0].indices) {
            if (!visited[i] && graph[i][j] == 1) {
                connection++
                dfs(i, graph, visited)
            }
        }
    }
    write("$connection")
    close()
}

fun dfs(node: Int, graph: Array<IntArray>, visited: BooleanArray) {
    visited[node] = true
    for (i in graph[node].indices) {
        if (graph[node][i] == 1 && !visited[i]) dfs(i, graph, visited)
    }
}
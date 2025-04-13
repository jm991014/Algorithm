import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val N = br.readLine().toInt()
        val numbers = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        val visited = BooleanArray(N + 1)
        var count = 0

        for (i in 0 until N) {
            if (!visited[i]) {
                numbers.dfs(visited, i)
                count++
            }
        }

        write("$count\n")
    }
    close()
}

fun IntArray.dfs(visited: BooleanArray, node: Int) {
    val stack = LinkedList<Int>().apply { push(node) }
    visited[node] = true

    while (stack.isNotEmpty()) {
        val next = this[stack.pop()] - 1
        if (!visited[next]) {
            stack.push(next)
            visited[next] = true
        }
    }
}
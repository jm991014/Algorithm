import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    write("${bfs(N, K)}")
    close()
}

fun bfs(N: Int, K: Int): Int {
    val queue = LinkedList<Pair<Int, Int>>().apply { offer(Pair(N, 0)) }
    val visited = BooleanArray(100001).apply { this[N] = true }

    while (queue.isNotEmpty()) {
        val (cur, time) = queue.poll()
        if (cur == K) return time
        if (cur - 1 in visited.indices && !visited[cur - 1]) {
            queue.offer(Pair(cur - 1, time + 1))
            visited[cur - 1] = true
        }
        if (cur + 1 in visited.indices && !visited[cur + 1]) {
            queue.offer(Pair(cur + 1, time + 1))
            visited[cur + 1] = true
        }
        if (cur * 2 in visited.indices && !visited[cur * 2]) {
            queue.offer(Pair(cur * 2, time + 1))
            visited[cur * 2] = true
        }
    }
    return -1
}
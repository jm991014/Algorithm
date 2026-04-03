import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val queue = LinkedList<Int>().apply { offer(N) }
    val visited = IntArray(100001) { -1 }.apply { this[N] = 0 }
    val count = IntArray(100001).apply { this[N] = 1 }

    while (queue.isNotEmpty()) {
        val curr = queue.poll()

        for (next in intArrayOf(curr - 1, curr + 1, curr * 2)) {
            if (next !in 0..100000) continue

            if (visited[next] == -1) {
                visited[next] = visited[curr] + 1
                count[next] = count[curr]
                queue.offer(next)
            } else if (visited[next] == visited[curr] + 1) {
                count[next] += count[curr]
            }
        }
    }

    bw.write("${visited[K]}\n${count[K]}")
    bw.close()
}
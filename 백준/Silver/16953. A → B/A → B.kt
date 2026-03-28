import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val (A, B) = br.readLine().split(" ").map { it.toLong() }

    bw.write("${bfs(A, B)}")

    bw.close()
}

fun bfs(A: Long, B: Long): Long {
    val queue = LinkedList<Pair<Long, Int>>().apply { offer(A to 0) }

    while (queue.isNotEmpty()) {
        val (num, count) = queue.poll()

        if (num == B) {
            return count + 1L
        }

        if (num > B) continue

        queue.offer(num * 2 to count + 1)
        queue.offer("${num}1".toLong() to count + 1)
    }

    return -1
}
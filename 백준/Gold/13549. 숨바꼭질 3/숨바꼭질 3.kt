import java.util.LinkedList
import java.util.PriorityQueue

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }).apply { offer(N to 0) }
    val visited = BooleanArray(1000001)

    while (queue.isNotEmpty()) {
        val (pos, t) = queue.poll()
        visited[pos] = true

        if (pos == K) {
            bw.write("$t")
            break
        }

        for ((np, dt) in arrayOf(pos + 1 to 1, pos - 1 to 1, pos * 2 to 0)) {
            if (np in 0..100000 && !visited[np]) {
                queue.offer(np to t + dt)
            }
        }
    }
    bw.close()
}

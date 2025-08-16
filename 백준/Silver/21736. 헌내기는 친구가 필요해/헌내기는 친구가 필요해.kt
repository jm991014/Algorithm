import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private var meet = 0

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val campus = Array(N) { br.readLine().toCharArray() }
    val queue : LinkedList<Pair<Int, Int>> = LinkedList()
    val visited = Array(N) { BooleanArray(M) }

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (campus[i][j] == 'I') {
                queue.offer(i to j)
                visited[i][j] = true
                break
            }
        }
    }

    campus.bfs(visited, queue)

    write("${if (meet == 0) "TT" else meet}")
    close()
}

fun Array<CharArray>.bfs(visited: Array<BooleanArray>, queue: LinkedList<Pair<Int, Int>>) {
    val directions = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        for ((dx, dy) in directions) {
            val nx = dx + cur.first
            val ny = dy + cur.second

            if (nx in this.indices && ny in this[0].indices && !visited[nx][ny] && this[nx][ny] != 'X') {
                queue.offer(nx to ny)
                visited[nx][ny] = true
                if (this[nx][ny] == 'P') meet++
            }
        }
    }
}
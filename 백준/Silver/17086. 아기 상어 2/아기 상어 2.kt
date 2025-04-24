import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    var safeDist = -1

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (map[i][j] == 0) safeDist = safeDist.coerceAtLeast(map.getSafeDistance(i, j))
        }
    }
    write("$safeDist")
    close()
}

private fun Array<IntArray>.getSafeDistance(x: Int, y: Int): Int {
    val directions = arrayOf(Pair(0, 1), Pair(1, 1), Pair(1, 0), Pair(1, -1), Pair(0, -1), Pair(-1, -1), Pair(-1, 0), Pair(-1, 1))
    val queue = LinkedList<Triple<Int, Int, Int>>().apply { offer(Triple(x, y, 0)) }
    val visited = Array(this.size) { BooleanArray(this[0].size) }.apply { this[x][y] = true }

    while (queue.isNotEmpty()) {
        val (curX, curY, dist) = queue.poll()

        if (this[curX][curY] == 1) return dist

        for ((dx, dy) in directions) {
            val nx = curX + dx
            val ny = curY + dy

            if (nx in this.indices && ny in this[0].indices && !visited[nx][ny]) {
                queue.offer(Triple(nx, ny, dist + 1))
                visited[nx][ny] = true
            }
        }
    }
    return -1
}

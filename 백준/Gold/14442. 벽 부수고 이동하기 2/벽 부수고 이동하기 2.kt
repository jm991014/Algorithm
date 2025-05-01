import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))

fun main() = with(System.out.bufferedWriter()) {
    val (N, M, K) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(N) { br.readLine().toCharArray() }

    if (N == 1 && M == 1) write("1")
    else write("${map.bfs(K)}")
    close()
}

private fun Array<CharArray>.bfs(k: Int): Int {
    val queue = LinkedList<Triple<Pair<Int, Int>, Int, Int>>().apply { offer(Triple(Pair(0, 0), 0, 1)) }
    val visited = Array(this.size) { Array(this[0].size) { BooleanArray(k + 1) } }.apply { this[0][0][0] = true }

    while (queue.isNotEmpty()) {
        val (coordinate, broken, dist) = queue.poll()

        if (coordinate.first == this.size - 1 && coordinate.second == this[0].size - 1) return dist

        for ((dx, dy) in directions) {
            val nx = coordinate.first + dx
            val ny = coordinate.second + dy

            if (nx !in this.indices || ny !in this[0].indices) continue

            val nBroken = if (this[nx][ny] == '1') broken + 1 else broken

            if (nBroken > k || visited[nx][ny][nBroken]) continue

            visited[nx][ny][nBroken] = true
            queue.offer(Triple(Pair(nx, ny), nBroken, dist + 1))
        }
    }
    return -1
}

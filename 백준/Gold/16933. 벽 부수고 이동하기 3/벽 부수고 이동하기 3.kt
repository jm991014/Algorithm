private val br = System.`in`.bufferedReader()
private val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))

private data class Point(var x: Int, var y: Int, var isDay: Boolean, var broken: Int, var dist: Int)

fun main() = with(System.out.bufferedWriter()) {
    val (N, M, K) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(N + 1) { CharArray(M + 1) }

    repeat(N) { row ->
        br.readLine().forEachIndexed { col, char ->
            map[row + 1][col + 1] = char
        }
    }

    write("${map.bfs(N, M, K)}")
    close()
}

private fun Array<CharArray>.bfs(N: Int, M: Int, K: Int): Int {
    val queue = ArrayDeque<Point>().apply { addLast(Point(1, 1, true, 0, 1)) }
    val visited = Array(N + 1) { IntArray(M + 1) { Int.MAX_VALUE } }.apply { this[1][1] = 0 }

    while (queue.isNotEmpty()) {
        val (x, y, isDay, broken, dist) = queue.removeFirst()

        if (x == N && y == M) return dist

        for ((dx, dy) in directions) {
            val nx = x + dx
            val ny = y + dy

            if (nx !in 1..N || ny !in 1..M || visited[nx][ny] <= broken) continue

            if (this[nx][ny] == '1') {
                if (broken >= K) continue

                if (isDay) {
                    queue.addLast(Point(nx, ny, false, broken + 1, dist + 1))
                    visited[nx][ny] = broken + 1
                } else queue.addLast(Point(x, y, true, broken, dist + 1))
            } else {
                queue.addLast(Point(nx, ny, !isDay, broken, dist + 1))
                visited[nx][ny] = broken
            }
        }
    }
    return -1
}

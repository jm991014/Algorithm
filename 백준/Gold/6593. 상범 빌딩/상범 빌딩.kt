import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    while (true) {
        val (L, R, C) = br.readLine().split(" ").map { it.toInt() }

        if (L == 0) break

        val building = Array(L) { Array(R) { CharArray(C) } }

        var start = Triple(0, 0, 0)

        for (i in 0 until L) {
            for (j in 0..R) {
                if (j == R) {
                    br.readLine()
                    continue
                } else building[i][j] = br.readLine().toCharArray()
                for (k in 0 until C) {
                    if (building[i][j][k] == 'S') start = Triple(i, j, k)
                }
            }
        }
        write("${building.bfs(start)}\n")
    }

    close()
}

private fun Array<Array<CharArray>>.bfs(start: Triple<Int, Int, Int>): String {
    val queue = LinkedList<Pair<Triple<Int, Int, Int>, Int>>().apply { offer(Pair(start, 0)) }
    val visited = Array(this.size) { Array(this[0].size) { BooleanArray(this[0][0].size) } }.apply { this[start.first][start.second][start.third] = true }
    val directions = arrayOf(Triple(0, -1, 0), Triple(0, 0, 1), Triple(0, 1, 0), Triple(0, 0, -1), Triple(1, 0, 0), Triple(-1, 0, 0),)

    while (queue.isNotEmpty()) {
        val (coordinate, move) = queue.poll()

        if (this[coordinate.first][coordinate.second][coordinate.third] == 'E') return "Escaped in $move minute(s)."

        for (i in directions.indices) {
            val dz = coordinate.first + directions[i].first
            val dy = coordinate.second + directions[i].second
            val dx = coordinate.third + directions[i].third

            if (dz in this.indices && dy in this[0].indices && dx in this[0][0].indices && !visited[dz][dy][dx] && this[dz][dy][dx] != '#') {
                queue.offer(Pair(Triple(dz, dy, dx), move + 1))
                visited[dz][dy][dx] = true
            }
        }
    }

    return "Trapped!"
}
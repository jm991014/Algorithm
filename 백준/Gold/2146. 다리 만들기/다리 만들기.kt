import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
private var minMove = 10001

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val map = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val visited = Array(N) { BooleanArray(N) }
    var island = 1

    for (i in 0 until N) {
        for (j in 0 until N) {
            if (!visited[i][j] && map[i][j] != 0) {
                map.splitIsland(i, j, island, visited)
                island++
            }
        }
    }

    for (i in 0 until N) {
        for (j in 0 until N) {
            if (map[i][j] != 0) map.findNearIsland(i, j, map[i][j])
        }
    }
    println(minMove)
}

private fun Array<IntArray>.splitIsland(x: Int, y: Int, island: Int, visited: Array<BooleanArray>) {
    val queue = LinkedList<Pair<Int, Int>>().apply { offer(Pair(x, y)) }
    visited[x][y] = true
    this[x][y] = island

    while (queue.isNotEmpty()) {
        val (curX, curY) = queue.poll()

        for (dir in directions) {
            val dx = curX + dir.first
            val dy = curY + dir.second

            if (dx in this.indices && dy in this[0].indices && !visited[dx][dy] && this[dx][dy] != 0) {
                queue.offer(Pair(dx, dy))
                this[dx][dy] = island
                visited[dx][dy] = true
            }
        }
    }
}

private fun Array<IntArray>.findNearIsland(x: Int, y: Int, island: Int) {
    val queue = LinkedList<Triple<Int, Int, Int>>().apply { offer(Triple(x, y, 0)) }
    val visited = Array(this.size) { BooleanArray(this[0].size) }.apply { this[x][y] = true }

    while (queue.isNotEmpty()) {
        val (curX, curY, move) = queue.poll()

        if (move > minMove) return

        if (this[curX][curY] != 0 && this[curX][curY] != island) {
            minMove = minMove.coerceAtMost(move - 1)
            return
        }

        for (dir in directions) {
            val dx = curX + dir.first
            val dy = curY + dir.second

            if (dx in this.indices && dy in this[0].indices && !visited[dx][dy] && this[dx][dy] != island) {
                queue.offer(Triple(dx, dy, move + 1))
                visited[dx][dy] = true
            }
        }
    }
}
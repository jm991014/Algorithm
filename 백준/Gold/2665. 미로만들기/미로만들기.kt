import java.util.PriorityQueue

private val br = System.`in`.bufferedReader()
private var minBroken = Int.MAX_VALUE

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val maze = Array(n) { br.readLine().toCharArray().map { it.digitToInt() }.toIntArray() }

    maze.bfs()
    write("$minBroken")
    close()
}

private fun Array<IntArray>.bfs() {
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    val queue = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third }).apply { offer(Triple(0, 0, 0)) }
    val visited = Array(this.size) { BooleanArray(this[0].size) }.apply { this[0][0] = true }

    while (queue.isNotEmpty()) {
        val (x, y, broken) = queue.poll()

        if (x == this.size - 1 && y == this[0].size - 1) {
            minBroken = minBroken.coerceAtMost(broken)
            return
        }

        for (dir in directions) {
            val dx = x + dir.first
            val dy = y + dir.second

            if (dx in this.indices && dy in this[0].indices && !visited[dx][dy]) {
                if (this[dx][dy] == 0) queue.offer(Triple(dx, dy, broken + 1)) else queue.offer(Triple(dx, dy, broken))
                visited[dx][dy] = true
            }
        }
    }
}

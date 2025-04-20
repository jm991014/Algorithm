import java.util.PriorityQueue

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var problem = 1
    while (true) {
        val N = br.readLine().toInt()

        if (N == 0) break

        val map = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

        write("Problem ${problem++}: ${map.bfs()}\n")
    }
    close()
}

private fun Array<IntArray>.bfs(): Int {
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    val queue = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third }).apply { offer(Triple(0, 0, this@bfs[0][0])) }
    val rupee = Array(this.size) { IntArray(this[0].size) { Int.MAX_VALUE } }.apply { this[0][0] = this@bfs[0][0] }

    while (queue.isNotEmpty()) {
        val (x, y, move) = queue.poll()

        for (dir in directions) {
            val dx = x + dir.first
            val dy = y + dir.second

            if (dx in this.indices && dy in this[0].indices && rupee[dx][dy] > rupee[x][y] + this[dx][dy]) {
                rupee[dx][dy] = rupee[x][y] + this[dx][dy]
                queue.offer(Triple(dx, dy, move + this[dx][dy]))
            }
        }
    }
    return rupee[this.size - 1][this[0].size - 1]
}

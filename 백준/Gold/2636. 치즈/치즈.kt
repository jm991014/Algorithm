import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(r) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    var cheese = map.sumOf { it.count { it == 1 } } // 현재 잔여 치즈
    var time = 0
    var lastCheese = 0

    while (cheese > 0) {
        map.checkEdge()
        time++
        lastCheese = cheese

        for (i in 0 until r) {
            for (j in 0 until c) {
                if (map[i][j] == -1) {
                    map[i][j] = 0
                    cheese--
                }
            }
        }
    }
    write("$time\n$lastCheese")
    close()
}

private fun Array<IntArray>.checkEdge() {
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    val queue = LinkedList<Pair<Int, Int>>().apply { offer(Pair(0, 0)) }
    val visited = Array(this.size) { BooleanArray(this[0].size) }.apply { this[0][0] = true }

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()

        for (dir in directions) {
            val dx = x + dir.first
            val dy = y + dir.second

            if (dx in this.indices && dy in this[0].indices && !visited[dx][dy]) {
                if (this[dx][dy] == 1) this[dx][dy] = -1 else queue.offer(Pair(dx, dy))
                visited[dx][dy] = true
            }
        }
    }
}

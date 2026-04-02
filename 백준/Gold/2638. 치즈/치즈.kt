import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val (N, M) = br.readLine().split(" ").map(String::toInt)
    val board = Array(N) { br.readLine().split(" ").map(String::toInt).toIntArray() }
    var cheese = board.sumOf { it.count { it == 1 } }
    var time = 0

    while (cheese != 0) {
        cheese -= board.bfs()
        time++
    }

    bw.write("$time")
    bw.close()
}

fun Array<IntArray>.bfs(): Int {
    val queue = LinkedList<Pair<Int, Int>>().apply { offer(0 to 0) }
    val visited = Array(size) { BooleanArray(this[0].size) }.apply { this[0][0] = true }
    val direction = arrayOf(1 to 0, 0 to 1, -1 to 0, 0 to -1)
    val map = mutableMapOf<Pair<Int, Int>, Int>()

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()

        for ((dx, dy) in direction) {
            val nx = x + dx
            val ny = y + dy

            if (nx in indices && ny in this[0].indices && !visited[nx][ny]) {
                if (this[nx][ny] == 0) {
                    queue.offer(nx to ny)
                    visited[nx][ny] = true
                } else {
                    val def = map.getOrDefault(nx to ny, 0) + 1
                    map[nx to ny] = def
                }
            }
        }
    }

    var cnt = 0
    map.forEach { (x, y), i ->
        if (i >= 2) {
            this[x][y] = 0
            cnt++
        }
    }

    return cnt
}
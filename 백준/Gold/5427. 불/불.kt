import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val (w, h) = br.readLine().split(" ").map { it.toInt() }
        val map = Array(h) { br.readLine().toCharArray() }
        val fire = LinkedList<Pair<Int, Int>>()
        var start = Pair(0, 0)

        for (i in 0 until h) {
            for (j in 0 until w) {
                if (map[i][j] == '@') {
                    start = Pair(i, j)
                    map[i][j] = '.'
                }
                if (map[i][j] == '*') fire.offer(Pair(i, j))
            }
        }
        write("${map.escape(start, fire)}\n")
    }
    close()
}

fun Array<CharArray>.escape(start: Pair<Int, Int>, fire: LinkedList<Pair<Int, Int>>): String {
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    val queue = LinkedList<Pair<Pair<Int, Int>, Int>>().apply { offer(Pair(start, 0)) }
    val visited = Array(this.size) { BooleanArray(this[0].size) }.apply { this[start.first][start.second] = true }

    while (queue.isNotEmpty()) {
        repeat(fire.size) { // 모든 불 이동
            val cur = fire.poll()

            for (i in directions.indices) {
                val dx = cur.first + directions[i].first
                val dy = cur.second + directions[i].second

                if (dx in this.indices && dy in this[0].indices && this[dx][dy] == '.') {
                    fire.offer(Pair(dx, dy))
                    this[dx][dy] = '*'
                }
            }
        }
        
        repeat(queue.size) {
            val (coordinate, move) = queue.poll()

            for (i in directions.indices) {
                val dx = coordinate.first + directions[i].first
                val dy = coordinate.second + directions[i].second
                
                if (dx !in indices || dy !in this[0].indices) return "${move + 1}"
                
                if (this[dx][dy] == '.' && !visited[dx][dy]) {
                    queue.offer(Pair(Pair(dx, dy), move + 1))
                    visited[dx][dy] = true
                }
            }
        }
    }
    return "IMPOSSIBLE"
}
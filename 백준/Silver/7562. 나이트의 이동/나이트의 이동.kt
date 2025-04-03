import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val I = br.readLine().toInt()
        val start = br.readLine().split(" ").map { it.toInt() }.let { it[0] to it[1]}
        val end = br.readLine().split(" ").map { it.toInt() }.let { it[0] to it[1]}
        val visited = Array(I) { BooleanArray(I) }

        write("${visited.bfs(start, end)}\n")
    }
    close()
}

private fun Array<BooleanArray>.bfs(start: Pair<Int, Int>, end: Pair<Int, Int>): Int {
    val directions = arrayOf(Pair(-2, 1), Pair(-1, 2), Pair(1, 2), Pair(2, 1), Pair(2, -1), Pair(1, -2), Pair(-1, -2), Pair(-2, -1))
    val queue = LinkedList<Pair<Pair<Int, Int>, Int>>().apply { offer(Pair(start, 0)) }

    while (queue.isNotEmpty()) {
        val (coordinate, move) = queue.poll()
        if (coordinate == end) return move

        for (i in directions.indices) {
            val dx = coordinate.first + directions[i].first
            val dy = coordinate.second + directions[i].second

            if (dx in this.indices && dy in this.indices && !this[dx][dy]) {
                queue.offer(Pair(Pair(dx, dy), move + 1))
                this[dx][dy] = true
            }
        }
    }
    return 0
}

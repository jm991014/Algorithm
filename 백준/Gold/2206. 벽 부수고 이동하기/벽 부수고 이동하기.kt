import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(N) { br.readLine().toCharArray() }
    val visited = Array(N) { Array(M) { BooleanArray(2) } }.apply {
        this[0][0][0] = true
        this[0][0][1] = true
    }
    write("${map.bfs(Pair(0, 0), Pair(N - 1, M - 1), visited)}")
    close()
}

fun Array<CharArray>.bfs(start: Pair<Int, Int>, end: Pair<Int, Int>, visited: Array<Array<BooleanArray>>): Int {
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    val queue = LinkedList<Triple<Pair<Int, Int>, Int, Int>>().apply { offer(Triple(start, 1, 0)) }

    while (queue.isNotEmpty()) {
        val (coordinate, move, broken) = queue.poll()

        if (coordinate == end) return move

        for (i in directions.indices) {
            val dx = coordinate.first + directions[i].first
            val dy = coordinate.second + directions[i].second

            if (dx !in this.indices || dy !in this[0].indices || (visited[dx][dy][0] && broken == 0) || (visited[dx][dy][1] && broken == 1)) continue

            if (this[dx][dy] == '1') {
                if (broken == 0 && !visited[dx][dy][1]) {
                    queue.offer(Triple(Pair(dx, dy), move + 1, 1))
                    visited[dx][dy][1] = true
                }
                continue
            }
            queue.offer(Triple(Pair(dx, dy), move + 1, broken))
            visited[dx][dy][broken] = true
        }
    }
    return -1
}

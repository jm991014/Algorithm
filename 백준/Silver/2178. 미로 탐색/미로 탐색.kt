import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private var count = 10001

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val maze = Array(N) { br.readLine().map { it.digitToInt() }.toIntArray() }
    bfs(maze)
    write("$count")
    close()
}

fun bfs(maze: Array<IntArray>) {
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    val queue = LinkedList<Triple<Int, Int, Int>>().apply { offer(Triple(0, 0, 1)) }
    val visited = Array(maze.size) { BooleanArray(maze[0].size) }.apply { this[0][0] = true }

    while (queue.isNotEmpty()) {
        val (curX, curY, depth) = queue.poll()
        if (curX == maze.size - 1 && curY == maze[0].size - 1) count = count.coerceAtMost(depth)
        for (direction in directions) {
            val dx = curX + direction.first
            val dy = curY + direction.second

            if (dx in maze.indices && dy in maze[0].indices && !visited[dx][dy] && maze[dx][dy] == 1) {
                visited[dx][dy] = true
                queue.offer(Triple(dx, dy, depth + 1))
            }
        }
    }
}
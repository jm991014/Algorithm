import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private var area = mutableListOf<Int>()

fun main() = with(System.out.bufferedWriter()) {
    val (M, N, K) = br.readLine().split(" ").map { it.toInt() }
    val paper = Array(M) { IntArray(N) }
    val visited = Array(M) { BooleanArray(N) }

    repeat (K) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
        for (i in y1 until y2) {
            for (j in x1 until x2) paper[i][j] = 1
        }
    }

    for (i in paper.indices) {
        for (j in paper[0].indices) {
            if (!visited[i][j] && paper[i][j] == 0) area.add(bfs(i, j, paper, visited))
        }
    }

    write("${area.size}\n${area.sorted().joinToString(" ")}")
    close()
}

fun bfs(x: Int, y: Int, area: Array<IntArray>, visited: Array<BooleanArray>): Int {
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    val queue = LinkedList<Pair<Int, Int>>().apply { offer(Pair(x, y)) }
    visited[x][y] = true
    var count = 1

    while (queue.isNotEmpty()) {
        val (curX, curY) = queue.poll()
        for (direction in directions) {
            val dx = curX + direction.first
            val dy = curY + direction.second
            if (dx in area.indices && dy in area[0].indices && !visited[dx][dy] && area[dx][dy] == 0) {
                visited[dx][dy] = true
                queue.offer(Pair(dx, dy))
                count++
            }
        }
    }
    return count
}
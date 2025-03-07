private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    while (true) {
        val (w, h) = br.readLine().split(" ").map { it.toInt() }
        if (w == 0) break
        val map = Array(h) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
        val visited = Array(h) { BooleanArray(w) }
        var island = 0

        repeat(h) { i ->
            repeat(w) { j ->
                if (map[i][j] == 1 && !visited[i][j]) {
                    island++
                    dfs(i, j, map, visited)
                }
            }
        }
        write("$island\n")
    }
    close()
}

fun dfs(x: Int, y: Int, map: Array<IntArray>, visited: Array<BooleanArray>) {
    val direction = arrayOf(Pair(1, 0), Pair(1, -1), Pair(0, -1), Pair(-1, -1), Pair(-1, 0), Pair(-1, 1), Pair(0, 1), Pair(1, 1))
    val stack = ArrayDeque<Pair<Int, Int>>().apply { add(Pair(x, y)) }
    visited[x][y] = true

    while (stack.isNotEmpty()) {
        val (curX, curY) = stack.removeLast()
        for (i in direction.indices) {
            val dx = curX + direction[i].first
            val dy = curY + direction[i].second
            if (dx in map.indices && dy in map[0].indices && !visited[dx][dy] && map[dx][dy] == 1) {
                visited[dx][dy] = true
                stack.add(Pair(dx, dy))
            }
        }
    }
}
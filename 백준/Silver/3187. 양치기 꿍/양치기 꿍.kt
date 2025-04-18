import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private val fence = mutableListOf<Pair<Int, Int>>()

fun main() = with(System.out.bufferedWriter()) {
    val (R, C) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(R) { br.readLine().toCharArray() }
    val visited = Array(R) { BooleanArray(C) }
    var sheep = map.sumOf { it.count { it == 'k' } }
    var wolf = map.sumOf { it.count { it == 'v' } }

    for (i in 0 until R) {
        for (j in 0 until C) {
            if (map[i][j] != '#' && !visited[i][j]) map.dfs(i, j, visited)
        }
    }

    fence.forEach {
        if (it.first >= it.second) sheep -= it.second
        else wolf -= it.first
    }

    write("$sheep $wolf")
    close()
}

private fun Array<CharArray>.dfs(x: Int, y: Int, visited: Array<BooleanArray>) {
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    val stack = LinkedList<Pair<Int, Int>>().apply { push(Pair(x, y)) }
    visited[x][y] = true
    var wolf = 0
    var sheep = 0

    while (stack.isNotEmpty()) {
        val (curX, curY) = stack.pop()

        if (this[curX][curY] == 'v') wolf++
        if (this[curX][curY] == 'k') sheep++
        for (dir in directions) {
            val dx = curX + dir.first
            val dy = curY + dir.second

            if (dx in this.indices && dy in this[0].indices && !visited[dx][dy] && this[dx][dy] != '#') {
                visited[dx][dy] = true
                stack.push(Pair(dx, dy))
            }
        }
    }
    fence.add(Pair(wolf, sheep))
}

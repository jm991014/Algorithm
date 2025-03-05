import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val case = br.readLine().toInt()

    repeat(case) {
        val (row, col, cabbage) = br.readLine().split(" ").map { it.toInt() }
        val farm = Array(row) { IntArray(col) }
        val visited = Array(row) { BooleanArray(col) }
        var worm = 0

        repeat(cabbage) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            farm[x][y] = 1
        }

        for (i in farm.indices) {
            for (j in farm[0].indices) {
                if (!visited[i][j] && farm[i][j] == 1) {
                    worm++
                    dfs(i, j, farm, visited)
                }
            }
        }

        write("$worm\n")
    }
    close()
}

fun dfs(x: Int, y: Int, farm: Array<IntArray>, visited: Array<BooleanArray>) {
    val stack = LinkedList<Pair<Int, Int>>().apply { push(Pair(x, y)) } // coordinate(x, y)
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    visited[x][y] = true

    while (stack.isNotEmpty()) {
        val (curX, curY) = stack.pop()

        for (i in directions.indices) {
            val dx = curX + directions[i].first
            val dy = curY + directions[i].second
            if (dx in farm.indices && dy in farm[0].indices && farm[dx][dy] == 1 && !visited[dx][dy]) {
                visited[dx][dy] = true
                stack.push(Pair(dx, dy))
            }
        }
    }
}
import java.util.LinkedList

private val br = System.`in`.bufferedReader()
var apartment = mutableListOf<Int>()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val map = Array(N) { br.readLine().toList().map { it.digitToInt() }.toIntArray() }
    val visited = Array(N) { BooleanArray(N) }

    for (i in map.indices) {
        for (j in map[0].indices) {
            if (!visited[i][j] && map[i][j] == 1) dfs(i, j, map, visited)
        }
    }
    write("${apartment.size}\n")
    apartment.sorted().forEach { write("${it}\n") }
    close()
}

fun dfs(x: Int, y: Int, map: Array<IntArray>, visited: Array<BooleanArray>) {
    val stack = LinkedList<Pair<Int, Int>>().apply { push(Pair(x, y)) } // coordinate(x, y), size
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    var count = 1
    visited[x][y] = true

    while (stack.isNotEmpty()) {
        val (curX, curY) = stack.pop()

        for (i in directions.indices) {
            val dx = curX + directions[i].first
            val dy = curY + directions[i].second
            if (dx in map.indices && dy in map[0].indices && map[dx][dy] == 1 && !visited[dx][dy]) {
                visited[dx][dy] = true
                stack.push(Pair(dx, dy))
                count++
            }
        }
    }
    apartment.add(count)
}
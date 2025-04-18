private val br = System.`in`.bufferedReader()
private val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
private val nums = mutableSetOf<String>()

fun main() = with(System.out.bufferedWriter()) {
    val board = Array(5) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    for (i in board.indices) {
        for (j in board[0].indices) {
            board.dfs(1, i, j, board[i][j].toString())
        }
    }

    write("${nums.size}")
    close()
}

private fun Array<IntArray>.dfs(depth: Int, x: Int, y: Int, numbers: String) {
    if (depth == 6) {
        nums.add(numbers)
        return
    }

    for (dir in directions) {
        val dx = x + dir.first
        val dy = y + dir.second

        if (dx in this.indices && dy in this[0].indices) this.dfs(depth + 1, dx, dy, numbers + this[dx][dy])
    }
}

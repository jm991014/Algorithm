private val br = System.`in`.bufferedReader()
private var count = 0

fun main() = with(System.out.bufferedWriter()) {
    val (R, C) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(R) { br.readLine().toCharArray() }
    val visited = mutableSetOf(board[0][0])

    dfs(0, 0, 1, board, visited)
    write("$count")
    close()
}

fun dfs(x: Int, y: Int, depth: Int, board: Array<CharArray>, visited: MutableSet<Char>) {
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    count = count.coerceAtLeast(depth)

    for (dir in directions) {
        val dx = x + dir.first
        val dy = y + dir.second
        if (dx in board.indices && dy in board[0].indices && !visited.contains(board[dx][dy])) {
            visited.add(board[dx][dy])
            dfs(dx, dy, depth + 1, board, visited)
            visited.remove(board[dx][dy])
        }
    }
}
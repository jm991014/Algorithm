private val br = System.`in`.bufferedReader()
private val directions = arrayOf(Pair(1, -1), Pair(1, 0), Pair(1, 1))
private var minSum = Int.MAX_VALUE

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val space = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    repeat(M) {
        space.dfs(-1, it, -1, 0)
    }

    write("$minSum")
    close()
}

private fun Array<IntArray>.dfs(x: Int, y: Int, dir: Int, sum: Int) {
    for (i in directions.indices) {
        if (dir == i) continue

        val dx = x + directions[i].first
        val dy = y + directions[i].second

        if (dx == this.size) {
            minSum = minSum.coerceAtMost(sum)
            return
        }

        if (dx in this.indices && dy in this[0].indices) dfs(dx, dy, i, sum + this[dx][dy])
    }
}

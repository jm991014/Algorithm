private val br = System.`in`.bufferedReader()
private val directions =
    arrayOf(Pair(-1, 0), Pair(-1, -1), Pair(0, -1), Pair(1, -1), Pair(1, 0), Pair(1, 1), Pair(0, 1), Pair(-1, 1))
private var totalScore = 0

fun main() = with(System.out.bufferedWriter()) {
    val ocean = Array(4) { br.readLine().split(" ").map { it.toInt() }.chunked(2).map { intArrayOf(it[0], it[1] - 1) }.toTypedArray() }

    ocean.dfs(0, 0, 0)
    write("$totalScore")
    close()
}

private fun Array<Array<IntArray>>.dfs(x: Int, y: Int, fishScore: Int) {
    val newOcean = Array(4) { i -> Array(4) { j -> this[i][j].clone() } }

    val currentScore = fishScore + newOcean[x][y][0]
    totalScore = totalScore.coerceAtLeast(currentScore)
    val sharkDir = newOcean[x][y][1]
    newOcean[x][y][0] = 0

    repeat(16) { index -> // 16마리 물고기
        var fish = Pair(-1, -1)

        loop@ for (i in 0 until 4) {
            for (j in 0 until 4) {
                if (newOcean[i][j][0] == index + 1) {
                    fish = Pair(i, j)
                    break@loop
                }
            }
        }

        if (fish.first == -1) return@repeat

        val fishDirection = newOcean[fish.first][fish.second][1]

        repeat(8) Inner@{
            val dir = (fishDirection + it) % 8
            val dx = fish.first + directions[dir].first
            val dy = fish.second + directions[dir].second

            if (dx !in 0 until 4 || dy !in 0 until 4 || (dx == x && dy == y)) return@Inner

            newOcean[fish.first][fish.second][1] = dir
            val temp = newOcean[fish.first][fish.second]
            newOcean[fish.first][fish.second] = newOcean[dx][dy]
            newOcean[dx][dy] = temp
            return@repeat
        }
    }

    repeat(4) {
        val dx = x + directions[sharkDir].first * (it + 1)
        val dy = y + directions[sharkDir].second * (it + 1)

        if (dx in newOcean.indices && dy in newOcean[0].indices && newOcean[dx][dy][0] > 0) {
            newOcean.dfs(dx, dy, currentScore)
        }
    }
}

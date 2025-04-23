private val br = System.`in`.bufferedReader()
private val directions = arrayOf(Pair(0, 1), Pair(0, -1), Pair(-1, 0), Pair(1, 0))
private lateinit var ac: Pair<Int, Int>

fun main() = with(System.out.bufferedWriter()) {
    val (R, C, T) = br.readLine().split(" ").map { it.toInt() }
    val room = Array(R) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    var totalDust = 2

    for (i in 0 until R) {
        if (room[i][0] == -1) {
            ac = i to i + 1
            break
        }
    }

    repeat(T) { room.spreadDust() }

    repeat(R) { totalDust += room[it].sum() }

    write("$totalDust")
    close()
}

private fun Array<IntArray>.spreadDust() {
    val dusts = mutableListOf<Pair<Int, Int>>()
    val nRoom = Array(this.size) { IntArray(this[0].size) }.apply {
        this[ac.first][0] = -1
        this[ac.second][0] = -1
    }

    for (i in this.indices) {
        for (j in this[0].indices) {
            if (this[i][j] > 0) dusts.add(i to j)
        }
    }

    dusts.forEach { (x, y) ->
        val amount = this[x][y] / 5
        var count = 0

        for ((dx, dy) in directions) {
            val nx = x + dx
            val ny = y + dy

            if (nx in this.indices && ny in this[0].indices && this[nx][ny] != -1) {
                nRoom[nx][ny] += amount
                count++
            }
        }
        nRoom[x][y] += this[x][y] - (amount * count)
    }

    for (i in ac.first - 1 downTo 1) nRoom[i][0] = nRoom[i - 1][0]
    for (i in 0 until this[0].size - 1) nRoom[0][i] = nRoom[0][i + 1]
    for (i in 0 until ac.first) nRoom[i][this[0].size - 1] = nRoom[i + 1][this[0].size - 1]
    for (i in this[0].size - 1 downTo 2) nRoom[ac.first][i] = nRoom[ac.first][i - 1]
    nRoom[ac.first][1] = 0

    for (i in ac.second + 1 until this.size - 1) nRoom[i][0] = nRoom[i + 1][0]
    for (i in 0 until this[0].size - 1) nRoom[this.size - 1][i] = nRoom[this.size - 1][i + 1]
    for (i in this.size - 1 downTo ac.second + 1) nRoom[i][this[0].size - 1] = nRoom[i - 1][this[0].size - 1]
    for (i in this[0].size - 1 downTo 2) nRoom[ac.second][i] = nRoom[ac.second][i - 1]
    nRoom[ac.second][1] = 0

    nRoom.copyInto(this)
}

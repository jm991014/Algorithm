import kotlin.math.abs

private val br = System.`in`.bufferedReader()

private var ans = 0

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val board = IntArray(N)
    board.dfs(0, N)
    write("$ans")
    close()
}

private fun IntArray.dfs(row: Int, N: Int) {
    if (row == N) {
        ans++
        return
    }
    for (i in 0 until N) {
        this[row] = i
        if (check(row)) dfs(row + 1, N)
    }
}

private fun IntArray.check(row: Int): Boolean {
    for (i in 0 until row) {
        if (this[i] == this[row] || row - i == abs(this[row] - this[i]))
            return false
    }
    return true
}

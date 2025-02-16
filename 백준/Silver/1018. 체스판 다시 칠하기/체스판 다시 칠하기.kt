private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (row, col) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(row) { br.readLine().toCharArray() }
    var min = 65
    for (i in 0..row - 8) for (j in 0..col - 8) {
        min = minOf(min, check(board, i, j, 'B'), check(board, i, j, 'W'))
    }
    write("$min")
    close()
}

fun check(board: Array<CharArray>, row: Int, col: Int, color: Char): Int {
    var count = 0
    for (i in 0..7) for (j in 0..7) {
        val expectedColor = if ((i + j) % 2 == 0) color else if (color == 'B') 'W' else 'B'
        if (board[row + i][col + j] != expectedColor) count++
    }
    return count
}
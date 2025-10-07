class Solution {
    fun solution(board: Array<IntArray>): Int {
        val directions = arrayOf(1 to 0, 1 to 1, 0 to 1, -1 to 1, -1 to 0, -1 to -1, 0 to -1, 1 to -1)
        val n = board.size
        
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (board[i][j] == 1) {
                    for ((dx, dy) in directions) {
                        val nx = i + dx
                        val ny = j + dy

                        if (nx in 0 until n && ny in 0 until n && board[nx][ny] == 0) board[nx][ny] = 2
                    }
                }
            }
        }
     
        return board.flatMap { it.toList() }.count { it == 0 }
    }
}
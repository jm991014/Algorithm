import java.util.LinkedList

class Solution {
    fun solution(places: Array<Array<String>>): IntArray = places.map { checkCase(it) }.toIntArray()

    fun checkCase(room: Array<String>): Int {
        for (r in room.indices) for (c in room[r].indices) {
            if (room[r][c] == 'P' && !bfs(room, r, c)) return 0
        }
        return 1
    }

    fun bfs(room: Array<String>, r: Int, c: Int): Boolean {
        val direction = arrayOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))
        val visited = Array(5) { BooleanArray(5) }.apply { this[r][c] = true }
        val queue = LinkedList<Triple<Int, Int, Int>>().apply { add(Triple(r, c, 0)) }

        while (queue.isNotEmpty()) {
            val (row, col, dist) = queue.poll()
            if (dist > 2) continue
            if (dist != 0 && room[row][col] == 'P') return false
            for (i in direction) {
                val nRow = row + i.first
                val nCol = col + i.second
                if (nRow < 0 || nRow > 4 || nCol < 0 || nCol > 4 || visited[nRow][nCol] || room[nRow][nCol] == 'X') continue
                visited[nRow][nCol] = true
                queue.add(Triple(nRow, nCol, dist + 1))
            }
        }
        return true
    }
}
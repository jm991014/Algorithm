import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private val directions = arrayOf(Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0))

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val K = br.readLine().toInt()
    val apples = Array(K) { br.readLine().split(" ").map { it.toInt() - 1 }.toIntArray() }
    val map = Array(N) { IntArray(N) }.apply { apples.forEach { this[it[0]][it[1]] = 1 } }
    val L = br.readLine().toInt()
    val snakeMoves = Array(L) { br.readLine().split(" ").let { it[0].toInt() to it[1] } }.toMutableList()
    val snake = LinkedList<Pair<Int, Int>>().apply { push(Pair(0, 0)) }
    var dir = 0
    var time = 0

    while (true) {
        val (x, y) = snake.peek()
        val dx = x + directions[dir].first
        val dy = y + directions[dir].second

        if (dx !in 0 until N || dy !in 0 until N || map[dx][dy] == -1) break

        snake.push(Pair(dx, dy))

        if (map[dx][dy] != 1) {
            val (tailX, tailY) = snake.removeLast()
            map[tailX][tailY] = 0
        }

        map[dx][dy] = -1

        time++

        if (snakeMoves.isNotEmpty() && time == snakeMoves[0].first) {
            dir = if (snakeMoves.removeAt(0).second == "D") (dir + 1) % 4 else (dir + 3) % 4
        }
    }
    write("${++time}")
    close()
}

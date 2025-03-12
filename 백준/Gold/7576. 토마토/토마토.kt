import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (M, N) = br.readLine().split(" ").map { it.toInt() }
    val box = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val queue = LinkedList<Pair<Int, Int>>()
    for (i in box.indices) {
        for (j in box[0].indices) {
            if (box[i][j] == 1) queue.offer(Pair(i, j))
        }
    }
    write("${bfs(queue, box)}")
    close()
}

fun bfs(queue: LinkedList<Pair<Int, Int>>, box: Array<IntArray>): Int {
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    var count = 0

    while (queue.isNotEmpty()) {
        val (curX, curY) = queue.poll()
        count = box[curX][curY]

        for (direction in directions) {
            val dx = curX + direction.first
            val dy = curY + direction.second

            if (dx in box.indices && dy in box[0].indices && box[dx][dy] == 0) {
                box[dx][dy] = count + 1
                queue.offer(Pair(dx, dy))
            }
        }
    }
    return if (box.any { it.contains(0) }) -1 else count - 1
}
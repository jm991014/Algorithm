import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private var totalWolves = 0
private var totalSheep = 0

fun main() = with(System.out.bufferedWriter()) {
    val (R, C) = br.readLine().split(" ").map { it.toInt() }
    val yard = Array(R) { br.readLine().toCharArray() }
    val visited = Array(R) { BooleanArray(C) }

    for (i in 0 until R) {
        for (j in 0 until C) {
            if (yard[i][j] != '#' && !visited[i][j]) yard.bfs(visited, i, j)
        }
    }
    write("$totalSheep $totalWolves")
    close()
}

fun Array<CharArray>.bfs(visited: Array<BooleanArray>, i: Int, j: Int) {
    val directions = arrayOf(1 to 0, 0 to -1, -1 to 0, 0 to 1)
    val queue = LinkedList<Pair<Int, Int>>().apply { offer(i to j) }
    visited[i][j] = true
    var wolves = if (this[i][j] == 'v') 1 else 0
    var sheep = if (this[i][j] == 'o') 1 else 0

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()

        for ((dx, dy) in directions) {
            val nx = x + dx
            val ny = y + dy

            if (nx !in this.indices || ny !in this[0].indices || visited[nx][ny] || this[nx][ny] == '#') continue

            when (this[nx][ny]) {
                'v' -> wolves++
                'o' -> sheep++
            }
            queue.offer(nx to ny)
            visited[nx][ny] = true
        }
    }

    if (wolves >= sheep) totalWolves += wolves
    else totalSheep += sheep
}
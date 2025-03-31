import java.util.LinkedList
import java.util.PriorityQueue

private val br = System.`in`.bufferedReader()
private lateinit var shark: Shark

data class Shark(var x: Int, var y: Int, var size: Int, var stack: Int, var time: Int)


fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val map = Array (N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    var totalTime = 0

    for (i in 0 until N) {
        for (j in 0 until N) {
            if (map[i][j] == 9) {
                shark = Shark(i, j, 2, 0, 0)
                map[i][j] = 0
            }
        }
    }

    while (true) {
        val result = map.bfs(N, shark)

        if (result.second == -1) break

        shark.apply {
            x = result.first.x
            y = result.first.y
            if (++stack == size) {
                size++
                stack = 0
            }
            map[x][y] = 0
        }
        totalTime += result.second
    }
    write("$totalTime")
    close()
}

fun Array<IntArray>.bfs(N: Int, shark: Shark): Pair<Shark, Int> {
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    val queue = LinkedList<Shark>().apply { offer(shark) }
    val fishQueue = PriorityQueue<Pair<Shark, Int>>(compareBy({ it.first.time }, { it.first.x }, { it.first.y })) // 시간 > x > y 순으로 정렬
    val visited = Array(N) { BooleanArray(N) }.apply { this[shark.x][shark.y] = true }

    while (queue.isNotEmpty()) {
        val cur = queue.poll()

        if (this[cur.x][cur.y] != 0 && this[cur.x][cur.y] < cur.size) { // 현재 상어의 크기에서 먹을 수 있는 모든 방향을 검색 후 우선순위 큐에 저장
            fishQueue.offer(Pair(cur, cur.time))
            continue
        }

        for (i in directions.indices) {
            val dx = cur.x + directions[i].first
            val dy = cur.y + directions[i].second

            if (dx in 0 until N && dy in 0 until N && this[dx][dy] <= cur.size && !visited[dx][dy]) {
                queue.offer(Shark(dx, dy, cur.size, cur.stack, cur.time + 1))
                visited[dx][dy] = true
            }
        }
    }
    return if (fishQueue.isEmpty()) Pair(shark, -1) else fishQueue.first()
}
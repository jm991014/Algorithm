import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val board = IntArray(100)

    val ladders = mutableListOf<Pair<Int, Int>>()
    repeat(N) {
        ladders.add(br.readLine().split(" ").map { it.toInt() }.let { Pair(it[0] - 1, it[1] - 1) } )
    }

    val snakes = mutableListOf<Pair<Int, Int>>()
    repeat(M) {
        snakes.add(br.readLine().split(" ").map { it.toInt() }.let { Pair(it[0] - 1, it[1] - 1) } )
    }

    board.bfs(0, ladders, snakes)
    write("${board[99]}")
    close()
}

fun IntArray.bfs(start: Int, ladders: MutableList<Pair<Int, Int>>, snakes: MutableList<Pair<Int, Int>>) {
    val queue = LinkedList<Pair<Int, Int>>().apply { offer(Pair(start, this@bfs[start])) }

    while (queue.isNotEmpty()) {
        val curr = queue.poll()

        for (i in 1..6) {
            var next = curr.first + i
            ladders.find { it.first == next }?.let { next = it.second }
            snakes.find { it.first == next }?.let { next = it.second }
            if (next < 100 && this[next] == 0) {
                this[next] = curr.second + 1
                queue.add(Pair(next, this[next]))
            }
        }
    }
}
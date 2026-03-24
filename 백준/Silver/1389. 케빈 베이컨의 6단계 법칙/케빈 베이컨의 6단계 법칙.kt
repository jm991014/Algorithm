import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map(String::toInt)
    val relation = Array(N + 1) { mutableListOf<Int>() }

    repeat(M) {
        val (A, B) = br.readLine().split(" ").map(String::toInt)
        relation[A].add(B)
        relation[B].add(A)
    }

    var minBacon = 500001
    var winner = 0

    for (i in 1..N) {
        val sum = relation.bfs(i, N)

        if (sum < minBacon) {
            minBacon = sum
            winner = i
        }
    }

    write("$winner")
    close()
}

fun Array<MutableList<Int>>.bfs(start: Int, N: Int): Int {
    val queue = LinkedList<Int>().apply { add(start) }
    val visited = IntArray(N + 1) { -1 }.apply { this[start] = 0 }

    var totalDist = 0

    while (queue.isNotEmpty()) {
        val curr = queue.poll()

        for (next in this[curr]) {
            if (visited[next] == -1) {
                visited[next] = visited[curr] + 1
                totalDist += visited[next]
                queue.add(next)
            }
        }
    }

    return totalDist
}
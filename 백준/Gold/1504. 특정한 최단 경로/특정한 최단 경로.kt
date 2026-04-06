import java.util.PriorityQueue

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

data class Edge(val to: Int, val cost: Int)

fun main() {
    val (N, E) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(N + 1) { mutableListOf<Edge>() }

    repeat(E) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(Edge(b, c))
        graph[b].add(Edge(a, c))
    }

    val (v1, v2) = br.readLine().split(" ").map { it.toInt() }

    val pathStart = graph.dijkstra(1)
    val pathV1 = graph.dijkstra(v1)
    val pathV2 = graph.dijkstra(v2)

    val pathA = pathStart[v1].toLong() + pathV1[v2].toLong() + pathV2[N].toLong()
    val pathB = pathStart[v2].toLong() + pathV2[v1].toLong() + pathV1[N].toLong()

    val minPath = pathA.coerceAtMost(pathB)

    if (minPath >= Int.MAX_VALUE) bw.write("-1") else bw.write("$minPath")
    bw.close()
}

fun Array<MutableList<Edge>>.dijkstra(start: Int): IntArray {
    val queue = PriorityQueue<Edge>(compareBy { it.cost }).apply { offer(Edge(start, 0)) }
    val dist = IntArray(size) { Int.MAX_VALUE }.apply { this[start] = 0 }

    while (queue.isNotEmpty()) {
        val (to, cost) = queue.poll()

        if (cost > dist[to]) continue

        for (next in this[to]) {
            val nextCost = cost + next.cost

            if (nextCost < dist[next.to]) {
                dist[next.to] = nextCost
                queue.offer(Edge(next.to, nextCost))
            }
        }
    }

    return dist
}
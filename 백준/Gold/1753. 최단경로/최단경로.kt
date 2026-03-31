import java.util.PriorityQueue

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

data class Node(val v: Int, val d: Int): Comparable<Node> {
    override fun compareTo(other: Node): Int = this.d - other.d
}

data class Edge(val to: Int, val w: Int)

fun main() {
    val (V, E) = br.readLine().split(" ").map { it.toInt() }
    val K = br.readLine().toInt()
    val graph = Array(V + 1) { mutableListOf<Edge>() }
    val dist = IntArray(V + 1) { Int.MAX_VALUE }.apply { this[K] = 0 }
    val pq = PriorityQueue<Node>().apply { offer(Node(K, 0)) }

    repeat(E) {
        val (u, v, w) = br.readLine().split(" ").map { it.toInt() }
        graph[u].add(Edge(v, w))
    }

    while (pq.isNotEmpty()) {
        val (v, d) = pq.poll()

        if (d > dist[v]) continue

        for (edge in graph[v]) {
            val newD = d + edge.w

            if (newD < dist[edge.to]) {
                dist[edge.to] = newD
                pq.offer(Node(edge.to, newD))
            }
        }
    }

    for (i in 1..V) {
        bw.write("${if (dist[i] != Int.MAX_VALUE) dist[i] else "INF"}\n")
    }
    bw.close()
}
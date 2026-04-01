private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    repeat(br.readLine().toInt()) {
        val (N, M, W) = br.readLine().split(" ").map(String::toInt)
        val graph = Array(N + 1) { mutableListOf<Pair<Int, Int>>() }

        repeat(M) {
            val (S, E, T) = br.readLine().split(" ").map(String::toInt)
            graph[S].add(E to T)
            graph[E].add(S to T)
        }

        repeat(W) {
            val (S, E, T) = br.readLine().split(" ").map(String::toInt)
            graph[S].add(E to -T)
        }

        if (graph.bellmanFord()) bw.write("YES\n") else bw.write("NO\n")
    }
    bw.close()
}

fun Array<MutableList<Pair<Int, Int>>>.bellmanFord(): Boolean {
    val dist = IntArray(size) { 0 }

    for (i in 1..<size) {
        for (u in 1..<size) {
            for (edge in this[u]) {
                val v = edge.first
                val w = edge.second

                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w
                    if (i == size - 1) return true
                }
            }
        }
    }

    return false
}
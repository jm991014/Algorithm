import java.util.PriorityQueue

private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val size = br.readLine().toInt()
    val cities = Array(size + 1) { mutableListOf<Pair<Int, Int>>() }

    repeat(br.readLine().toInt()) {
        val (start, end, cost) = br.readLine().split(" ").map(String::toInt)
        cities[start].add(end to cost)
    }
    val (start, dest) = br.readLine().split(" ").map(String::toInt)
    println(cities.dijkstra(start, dest))
}

fun Array<MutableList<Pair<Int, Int>>>.dijkstra(start: Int, end: Int): Int {
    val distance = IntArray(size) { Int.MAX_VALUE }.apply { this[start] = 0 }
    val pQueue = PriorityQueue<Pair<Int, Int>> { (_, cost1), (_, cost2) ->
        cost1.compareTo(cost2)
    }
    pQueue.offer(Pair(start, 0))

    while (pQueue.isNotEmpty()) {
        val (node, cost) = pQueue.poll()

        if (distance[node] < cost) continue

        this[node].forEach { next ->
            val nextNode = next.first
            val nextCost = next.second + cost

            if (nextCost < distance[nextNode]) {
                distance[nextNode] = nextCost
                pQueue.offer(nextNode to nextCost)
            }
        }
    }

    return distance[end]
}
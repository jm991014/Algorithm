import java.util.*

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {        
        val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
        val dist = Array(n + 1) { Int.MAX_VALUE }
        dist[1] = 0
        
        val pQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

        edge.forEach { (start, end) ->
            graph[start].add(Pair(end, 1))
            graph[end].add(Pair(start, 1))
        }
        
        pQueue.add(Pair(1, 0))
        
        while (pQueue.isNotEmpty()) {
            val (currentNode, currentDist) = pQueue.poll()
            
            if (dist[currentNode] < currentDist) continue
            
            for (i in graph[currentNode]) {
                val nextDist = currentDist + i.second
                if (nextDist < dist[i.first]) {
                    dist[i.first] = nextDist
                    pQueue.add(Pair(i.first, nextDist))
                }
            }
        }
        val maxDist = dist.drop(1).maxOrNull()
        return dist.count { it == maxDist }
    }
}
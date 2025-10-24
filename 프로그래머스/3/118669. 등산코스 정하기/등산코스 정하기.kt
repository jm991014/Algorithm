import java.util.*

class Solution {
    fun solution(n: Int, paths: Array<IntArray>, gates: IntArray, summits: IntArray): IntArray {        
        val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
        val gateSet = gates.toSet()
        val summitSet = summits.toSet()
        
        paths.forEach { (start, end, dist) ->
            when {
                start in gateSet || end in summitSet -> graph[start].add(end to dist)
                
                start in summitSet || end in gateSet -> graph[end].add(start to dist)

                else -> {
                    graph[start].add(end to dist)
                    graph[end].add(start to dist)
                }
            }
            graph[start].add(end to dist)
            graph[end].add(start to dist)
        }
        
        return graph.dijkstra(n, gates, summitSet)
            .let { intArrayOf(it.first, it.second) }
    }
    
    fun Array<MutableList<Pair<Int, Int>>>.dijkstra(n: Int, gates: IntArray, summits: Set<Int>): Pair<Int, Int> {
        val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        val intensity = IntArray(size + 1) { Int.MAX_VALUE }
        
        gates.forEach {
            queue.offer(it to 0)
            intensity[it] = 0
        }
        
        while (queue.isNotEmpty()) {
            val (curNode, curIntensity) = queue.poll()
            
            if (curIntensity > intensity[curNode] || curNode in summits) continue
            
            this[curNode].forEach { (nextNode, dist) ->
                val cost = curIntensity.coerceAtLeast(dist)
                
                if (cost < intensity[nextNode]) {
                    intensity[nextNode] = cost
                    queue.offer(nextNode to cost)
                }
            }
            
        }
        
        return summits.map { it to intensity[it] }
            .minWithOrNull(compareBy({ it.second }, { it.first }))!!
    }
}
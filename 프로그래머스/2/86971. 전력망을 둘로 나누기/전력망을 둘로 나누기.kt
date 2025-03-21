import java.util.LinkedList

class Solution {
    var min = mutableListOf<Int>()
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = n
        
        repeat(n - 1) {
            min.clear()
            val graph = wires.splitWire(wires[it], n)
            val visited = BooleanArray(n + 1)
            
            for (i in 1 until graph.size) {
                if (!visited[i]) bfs(i, i, graph, visited)
            }
            answer = answer.coerceAtMost(Math.abs(min[0] - min[1]))
        }
        return answer
    }
    
    fun bfs(from: Int, to: Int, graph: Array<IntArray>, visited: BooleanArray) {
        val queue = LinkedList<Pair<Int, Int>>().apply { add(Pair(from, to)) }
        visited[from] = true
        var count = 1
        
        while (queue.isNotEmpty()) {
            val (curF, curT) = queue.poll()
            
            for (i in graph.indices) {
                if (graph[curT][i] == 1 && !visited[i]) {
                    visited[i] = true
                    count++
                    queue.add(Pair(curT, i))
                }
            }
        }
        min.add(count)
    }

    fun Array<IntArray>.splitWire(wire: IntArray, n: Int): Array<IntArray> {
        val splitWires = this.toMutableList()
        val graph = Array(n + 1) { IntArray(n + 1) }
        splitWires.remove(wire)
        splitWires.forEach {
            val (from, to) = it
            graph[from][to] = 1
            graph[to][from] = 1
        }
        return graph
    }
}
import java.util.LinkedList

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        val queue = LinkedList<Pair<Int, Int>>().apply { add(Pair(x, 0)) }
        val visited = hashMapOf<Int, Boolean>()

        return queue.bfs(x, y, n, visited)
    }

    fun LinkedList<Pair<Int, Int>>.bfs(x: Int, y: Int, n: Int, visited: HashMap<Int, Boolean>): Int{
        while (isNotEmpty()) {
            val (value, count) = poll()

            if (value > y) continue
            if (value == y) return count

            if (!(visited[value + n] ?: false)) {
                add(Pair(value + n, count + 1))
                visited[value + n] = true
            }
            if (!(visited[value * 2] ?: false)) {
                add(Pair(value * 2, count + 1))
                visited[value * 2] = true
            }
            if (!(visited[value * 3] ?: false)) {
                add(Pair(value * 3, count + 1))
                visited[value * 3] = true
            }
        }
        
        return -1
    }
}
import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val n = br.readLine().toInt()
    val tree = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }

    repeat(n - 1) {
        val (parent, child, vertex) = br.readLine().split(" ").map { it.toInt() }
        tree[parent].add(Pair(child, vertex))
        tree[child].add(Pair(parent, vertex))
    }
    val (maxNode, _) = tree.bfs(1, n)
    val (_, maxDist) = tree.bfs(maxNode, n)

    println(maxDist)
}

fun Array<MutableList<Pair<Int, Int>>>.bfs(root: Int, n: Int): Pair<Int, Int> {
    val stack = LinkedList<Pair<Int, Int>>().apply { push(Pair(root, 0)) }
    val visited = BooleanArray(n + 1).apply { this[root] = true }
    var maxDist = 0
    var maxNode = root

    while (stack.isNotEmpty()) {
        val (node, dist) = stack.pop()

        if (dist > maxDist) {
            maxDist = dist
            maxNode = node
        }

        this[node].forEach { (nextNode, nextDist) ->
            if (!visited[nextNode]) {
                stack.push(Pair(nextNode, dist + nextDist))
                visited[nextNode] = true
            }
        }
    }
    return maxNode to maxDist
}
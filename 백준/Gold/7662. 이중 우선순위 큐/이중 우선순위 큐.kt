import java.util.PriorityQueue

private val br = System.`in`.bufferedReader()

data class Node(val index: Int, val value: Int)

fun PriorityQueue<Node>.poll(deleted: BooleanArray): Node? {
    while (isNotEmpty() && deleted[peek().index]) {
        poll()
    }
    return poll()
}

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val k = br.readLine().toInt()
        val minQueue = PriorityQueue<Node>(compareBy { it.value })
        val maxQueue = PriorityQueue<Node>(compareByDescending { it.value })
        val deleted = BooleanArray(k)

        repeat(k) {
            val (operator, n) = br.readLine().split(" ")
            val N = n.toInt()
            when (operator) {
                "I" -> {
                    minQueue.offer(Node(it, N))
                    maxQueue.offer(Node(it, N))
                }
                "D" -> {
                    val targetQueue = if (N == 1) maxQueue else minQueue
                    targetQueue.poll(deleted)?.also { deleted[it.index] = true }
                }
            }
        }
        val max = maxQueue.poll(deleted)
        val min = minQueue.poll(deleted)

        if (max == null || min == null) {
            write("EMPTY\n")
        } else {
            write("${max.value} ${min.value}\n")
        }
    }
    close()
}

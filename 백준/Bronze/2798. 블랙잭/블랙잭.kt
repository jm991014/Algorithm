import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (_, M) = br.readLine().split(" ").map { it.toInt() }
    val cards = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    write("${dfs(cards, M)}")
    close()
}

fun dfs(cards: IntArray, M: Int): Int {
    var sum = 0
    val stack = LinkedList<Triple<Int, Int, Int>>().apply { push(Triple(0, 0, 0)) }

    while (stack.isNotEmpty()) {
        val (current, size, index) = stack.pop()

        if (size == 3) {
            if (current in (sum + 1)..M) sum = current
            continue
        }

        for (i in index until cards.size) {
            val next = current + cards[i]
            if (next <= M) stack.push(Triple(next, size + 1, i + 1))
        }
    }

    return sum
}
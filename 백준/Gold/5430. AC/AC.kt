import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val p = br.readLine()
        val n = br.readLine().toInt()
        val queue = LinkedList(br.readLine().removeSurrounding("[", "]").split(","))
        var isReversed = false

        if (p.count { it == 'D' } > n) {
            write("error\n")
            return@repeat
        }

        p.forEach {
            when (it) {
                'D' -> {
                    if (queue.isEmpty()) {
                        write("error\n")
                        return@repeat
                    }
                    if (isReversed) queue.removeLast()
                    else queue.removeFirst()
                }
                'R' -> isReversed = !isReversed
            }
        }
        val out = if (isReversed) queue.asReversed() else queue
        write("[${out.joinToString(",")}]\n")
    }
    close()
}
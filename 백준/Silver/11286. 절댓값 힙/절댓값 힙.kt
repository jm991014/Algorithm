import java.util.PriorityQueue
import kotlin.math.abs

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val heap = PriorityQueue<Int> { a, b ->
        val diff = abs(a) - abs(b)
        if (diff == 0) a - b else diff
    }

    repeat(br.readLine().toInt()) {
        val num = br.readLine().toInt()
        if (num == 0) {
            write(if (heap.isEmpty()) "0\n" else "${heap.remove()}\n")
        } else heap.offer(num)
    }
    close()
}

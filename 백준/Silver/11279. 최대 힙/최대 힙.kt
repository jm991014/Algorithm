import java.util.PriorityQueue

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val pq = PriorityQueue<Int>(compareByDescending { it })
    repeat(br.readLine().toInt()) {
        val command = br.readLine().toInt()

        if (command == 0) {
            if (pq.isEmpty()) write("0\n")
            else write("${pq.poll()}\n")
        } else pq.add(command)
    }
    close()
}

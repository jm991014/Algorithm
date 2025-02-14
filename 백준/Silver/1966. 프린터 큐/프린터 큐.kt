import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val (_, target) = br.readLine().split(" ").map { it.toInt() }
        val document = LinkedList<Pair<Int, Int>>().apply {
            addAll(br.readLine().split(" ").mapIndexed { index, num -> Pair(num.toInt(), index) })
        }
        val print = mutableListOf<Pair<Int, Int>>()
        while(document.isNotEmpty()) {
            val max = document.maxOf { it.first }
            if (document[0].first == max) print.add(document.poll())
            else document.offer(document.poll())
        }
        write("${print.indexOf(print.find { it.second == target }) + 1}\n")
    }
    close()
}
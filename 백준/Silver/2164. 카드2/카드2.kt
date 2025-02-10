import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val card = LinkedList<Int>()
    (1..br.readLine().toInt()).map { card.add(it) }
    while (card.size > 1) {
        card.poll()
        val next = card.poll()
        card.addLast(next)
    }
    write("${card.first()}")
    close()
}
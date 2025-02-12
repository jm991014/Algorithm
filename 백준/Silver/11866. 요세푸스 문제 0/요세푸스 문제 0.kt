private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val list = (1..N).map { it }.toMutableList()
    var startIndex = 0
    val answer = mutableListOf<Int>()
    while (list.isNotEmpty()) {
        val removeIndex = (startIndex + K - 1) % list.size
        answer.add(list[removeIndex])
        list.removeAt(removeIndex)
        startIndex = removeIndex
    }
    write("<${answer.joinToString(", ")}>")
    close()
}
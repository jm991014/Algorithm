private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val queue = (1..N).toMutableList()
    var start = 0
    append("<")

    while (queue.size > 1) {
        val remove = (start + K - 1) % queue.size
        append("${queue.removeAt(remove)}, ")
        start = remove
    }
    append("${queue.first()}>")
    print(this)
}
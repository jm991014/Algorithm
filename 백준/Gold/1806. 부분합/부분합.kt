private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, S) = br.readLine().split(" ").map { it.toInt() }
    val sequence = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var count = Int.MAX_VALUE
    var tmpSum = 0
    var start = 0
    var end = 0

    while (true) {
        if(tmpSum >= S) {
            count = minOf(count, end - start)
            tmpSum -= sequence[start++]
        } else {
            if (end == N) break
            tmpSum += sequence[end++]
        }
    }

    write(if(count == Int.MAX_VALUE) "0" else "$count")
    close()
}

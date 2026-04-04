private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val (N, S) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toLong() }.toLongArray()
    var min = Int.MAX_VALUE
    var start = 0
    var end = 0
    var sum = 0L

    while (true) {
        if (sum >= S) {
            min = min.coerceAtMost(end - start)
            sum -= arr[start++]
        } else if (end == N) break
        else sum += arr[end++]
    }

    bw.write(if (min == Int.MAX_VALUE) "0" else "$min")
    bw.close()
}
private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var (N, K) = br.readLine().split(" ").map { it.toInt() }
    val coins = IntArray(N) { br.readLine().toInt() }
    var cnt = 0

    for (i in N - 1 downTo 0) {
        cnt += K / coins[i]
        K %= coins[i]
    }

    write("$cnt")
    close()
}
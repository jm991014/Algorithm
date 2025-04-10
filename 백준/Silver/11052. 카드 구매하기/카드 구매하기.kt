private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val card = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp = IntArray(N + 1)

    for (i in 1..N) {
        for (j in 1..i) {
            dp[i] = dp[i].coerceAtLeast(dp[i - j] + card[j - 1])
        }
    }
    write("${dp[N]}")
    close()
}
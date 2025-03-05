private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val dp = Array(N + 1) { 0 }

    for (i in 2..N) {
        dp[i] = dp[i - 1] + 1
        if (i % 2 == 0) dp[i] = dp[i].coerceAtMost(dp[i / 2] + 1)
        if (i % 3 == 0) dp[i] = dp[i].coerceAtMost(dp[i / 3] + 1)
    }
    write("${dp[N]}")
    close()
}
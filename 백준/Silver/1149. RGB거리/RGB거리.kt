private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val dp = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    for (i in 1 until N) {
        dp[i][0] = dp[i - 1][1].coerceAtMost(dp[i - 1][2]) + dp[i][0]
        dp[i][1] = dp[i - 1][0].coerceAtMost(dp[i - 1][2]) + dp[i][1]
        dp[i][2] = dp[i - 1][0].coerceAtMost(dp[i - 1][1]) + dp[i][2]
    }
    write("${minOf(dp[N - 1][0], dp[N - 1][1], dp[N - 1][2])}")
    close()
}
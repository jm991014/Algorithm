private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, K) = br.readLine().split(" ").map(String::toInt)
    val dp = Array(K + 1) { IntArray(N + 1) { 1 } }
    for (i in 2..K) for (j in 1..N) dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_000
    write("${dp[K][N]}")
    close()
}
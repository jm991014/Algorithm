private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val dp = Array(N + 1) { Array(M) { IntArray(3) { Int.MAX_VALUE } } }
    var answer = Int.MAX_VALUE

    repeat(M) { dp[0][it].fill(0) }

    for (i in 1..N) {
        for (j in 0 until M) {
            if (j != 0) dp[i][j][0] = dp[i][j][0].coerceAtMost(dp[i - 1][j - 1][1].coerceAtMost(dp[i - 1][j - 1][2]) + map[i - 1][j])
            dp[i][j][1] = dp[i][j][1].coerceAtMost(dp[i - 1][j][0].coerceAtMost(dp[i - 1][j][2]) + map[i - 1][j])
            if (j != M - 1) dp[i][j][2] = dp[i][j][2].coerceAtMost(dp[i - 1][j + 1][0].coerceAtMost(dp[i - 1][j + 1][1]) + map[i - 1][j])
        }
    }
    repeat(M) {
        answer = answer.coerceAtMost(dp[N][it].minOf { it })
    }

    write("$answer")
    close()
}

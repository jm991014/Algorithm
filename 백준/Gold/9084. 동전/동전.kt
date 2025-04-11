private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val N = br.readLine().toInt()
        val coins = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        val M = br.readLine().toInt()
        val dp = Array(N) { IntArray(M + 1).apply { this[0] = 1 } }

        for (i in 0 until N) {
            for (j in 1..M) {
                if (i - 1 >= 0) dp[i][j] += dp[i - 1][j]
                if (j - coins[i] >= 0) dp[i][j] += dp[i][j - coins[i]]
            }
        }
        write("${dp[N - 1][M]}\n")
    }
    close()
}
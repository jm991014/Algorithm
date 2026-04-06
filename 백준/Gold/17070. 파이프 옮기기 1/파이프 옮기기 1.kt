private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val N = br.readLine().toInt()
    val graph = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val dp = Array(N) { Array(N) { IntArray(3) } }.apply { this[0][1][0] = 1 }

    for (r in 0 until N) {
        for (c in 2 until N) {
            if (graph[r][c] == 1) continue

            dp[r][c][0] = dp[r][c - 1][0] + dp[r][c - 1][2]

            if (r > 0) dp[r][c][1] = dp[r - 1][c][1] + dp[r - 1][c][2]

            if (r > 0 && graph[r - 1][c] == 0 && graph[r][c - 1] == 0) {
                dp[r][c][2] = dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2]
            }
        }
    }

    val answer = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]
    bw.write("$answer")
    bw.close()
}

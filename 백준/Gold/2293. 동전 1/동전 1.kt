private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val coins = IntArray(n) { br.readLine().toInt() }
    val dp = IntArray(k + 1).apply { this[0] = 1 }

    for (i in 0 until n) {
        for(j in 0..k) {
            if (j - coins[i] >= 0) dp[j] += dp[j - coins[i]]
        }
    }

    write("${dp[k]}")
    close()
}
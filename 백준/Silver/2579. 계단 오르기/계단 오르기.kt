private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val stairs = IntArray(N) { br.readLine().toInt() }
    val dp = IntArray(N + 1).apply {
        this[1] = stairs[0]
        if (N > 1) this[2] = stairs[0] + stairs[1]
    }

    for (i in 3..N) {
        dp[i] = dp[i - 2].coerceAtLeast(dp[i - 3] + stairs[i - 2]) + stairs[i - 1]
    }
    write("${dp[N]}")
    close()
}

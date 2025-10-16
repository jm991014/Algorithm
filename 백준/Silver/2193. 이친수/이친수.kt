private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val dp = LongArray(90).apply {
        this[0] = 1
        this[1] = 1
    }
    for (i in 2 until 90) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    write("${dp[N - 1]}")
    close()
}
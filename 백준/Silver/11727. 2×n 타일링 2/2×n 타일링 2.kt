private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val N = br.readLine().toInt()
    val dp = LongArray(1001).apply {
        this[1] = 1
        this[2] = 3
    }

    for (i in 3..N) {
        dp[i] = ((dp[i - 2] * 2) + dp[i - 1]) % 10007
    }

    println(dp[N])
}
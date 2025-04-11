private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val arr = Array<Pair<Int, Int>>(N) { br.readLine().split(" ").let { it[0].toInt() to it[1].toInt() }}
    val dp = IntArray(N + 1)

    for (i in 0 until N) {
        if (i > 0) dp[i] = dp[i].coerceAtLeast(dp[i - 1])
        if (arr[i].first + i <= N) dp[i + arr[i].first] = dp[i + arr[i].first].coerceAtLeast(dp[i] + arr[i].second)
    }
    write("${dp.maxOf { it }}")
    close()
}
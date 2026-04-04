private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val N = br.readLine().toInt()
    val schedules = Array(N) { br.readLine().split(" ").map(String::toInt) }
    val dp = LongArray(N + 1)

    for (i in N - 1 downTo 0) {
        val t = schedules[i][0]
        val p = schedules[i][1].toLong()

        if (i + t <= N) dp[i] = maxOf(dp[i + 1], p + dp[i + t])
        else dp[i] = dp[i + 1]
    }
    bw.write("${dp[0]}")
    bw.close()
}

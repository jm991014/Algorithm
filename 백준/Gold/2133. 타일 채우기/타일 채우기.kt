private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val N = br.readLine().toInt()
    val dp = IntArray(31).apply {
        this[0] = 1
        this[2] = 3
    }

    for (i in 4..31 step 2) {
        dp[i] += 3 * dp[i - 2]

        for (j in i - 4 downTo 0 step 2) {
            dp[i] += 2 * dp[j]
        }
    }

    println(dp[N])
}
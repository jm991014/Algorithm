private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val dp = IntArray(1001).apply {
        this[1] = 1
        this[2] = 2
    }

    for (i in 3..1000) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10007
    }

    write("${dp[br.readLine().toInt()]}")
    close()
}
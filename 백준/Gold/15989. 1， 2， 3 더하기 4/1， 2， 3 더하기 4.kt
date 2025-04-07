private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val dp = Array(10004) { IntArray(3) }.apply {
        this[1][0] = 1;
        this[2][0] = 1;
        this[2][1] = 1;
        this[3][0] = 1;
        this[3][1] = 1;
        this[3][2] = 1;
    }
    
    for (i in 4..10000) {
        dp[i][0] = 1
        dp[i][1] = dp[i - 2][0] + dp[i - 2][1]
        dp[i][2] = dp[i - 3][0] + dp[i - 3][1] + dp[i - 3][2]
    }

    repeat(br.readLine().toInt()) {
        val N = br.readLine().toInt()
        write("${dp[N][0] + dp[N][1] + dp[N][2]}\n")
    }
    close()
}
private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val dp = Array(31) { LongArray(31) }

    for(i in 1 .. 30) {
        dp[i][i] = 1
        dp[i][0] = 1
    }

    for(i in 2..30) {
        for (j in 1..30) {
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
        }
    }

    repeat(br.readLine().toInt()) {
        val (w, e) = br.readLine().split(" ").map(String::toInt)
        write("${dp[e][w]}\n")
    }
    close()
}
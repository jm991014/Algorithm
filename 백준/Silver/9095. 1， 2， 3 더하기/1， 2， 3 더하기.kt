private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val dp = IntArray(11).apply {
        this[0] = 1
        this[1] = 2
        this[2] = 4
    }

    for (i in 3 until 11) {
        dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]
    }
    
    repeat(br.readLine().toInt()) {
        write("${dp[br.readLine().toInt() - 1]}\n")
    }
    close()
}

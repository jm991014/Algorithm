private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val A = br.readLine()
    val B = br.readLine()
    val dp = Array(A.length + 1) { IntArray(B.length + 1) }

    for (i in 1..A.length) {
        for (j in 1..B.length) {
            if (A[i - 1] == B[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = dp[i][j - 1].coerceAtLeast(dp[i - 1][j])
            }
        }
    }
    bw.write("${dp.flatMap { it.toList() }.maxOf { it } }")
    bw.close()
}
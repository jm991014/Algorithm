private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val dp = Array(15) { IntArray(15) }
    repeat(15) { a ->
        repeat(15) { b ->
            if (a == 0 || b == 0) dp[a][b] = b + 1
            else dp[a][b] = dp[a - 1][b] + dp[a][b - 1]
        }
    }
    repeat(br.readLine().toInt()) {
        write("${dp[br.readLine().toInt()][br.readLine().toInt() - 1]}\n")
    }
    close()
}
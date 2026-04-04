private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val N = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp = IntArray(N) { 1 }

    for (i in 1 until N) {
        for (j in 0..i) {
            if (arr[j] < arr[i]) dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
        }
    }

    bw.write("${dp.maxOf { it }}")
    bw.close()
}

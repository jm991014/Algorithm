private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val size = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(size)

    for (i in 0 until size) {
        dp[i] = arr[i]

        for (j in 0..i) {
            if (arr[i] > arr[j]) dp[i] = dp[i].coerceAtLeast(dp[j] + arr[i])
        }
    }

    write("${dp.maxOf { it }}\n")
    close()
}
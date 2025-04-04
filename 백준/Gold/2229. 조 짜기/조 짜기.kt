private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val students = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp = IntArray(N + 1)

    for (i in 0..N) {
        var max = Integer.MIN_VALUE
        var min = Integer.MAX_VALUE

        for (j in i downTo 1) {
            max = max.coerceAtLeast(students[j - 1])
            min = min.coerceAtMost(students[j - 1])
            dp[i] = dp[i].coerceAtLeast(max - min + dp[j - 1])
        }
    }
    write("${dp[N]}")
    close()
}
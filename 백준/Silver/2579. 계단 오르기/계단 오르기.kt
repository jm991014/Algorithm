private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val n = br.readLine().toInt()
    val steps = IntArray(n + 1)

    for (i in 1..n) steps[i] = br.readLine().toInt()

    val dp = IntArray(n + 1).apply {
        this[1] = steps[1]
        if (n >= 2) this[2] = steps[1] + steps[2]
    }

    for (i in 3..n) {
        dp[i] = (steps[i] + steps[i - 1] + dp[i - 3]).coerceAtLeast(steps[i] + dp[i - 2])
    }
    println(dp[n])
}
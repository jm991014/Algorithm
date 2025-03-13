private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val prefix = IntArray(N + 1)
    var max = Integer.MIN_VALUE

    for (i in nums.indices) {
        prefix[i + 1] = nums[i] + prefix[i]
    }

    for (i in 0 until prefix.size - K) {
        max = max.coerceAtLeast(prefix[i + K] - prefix[i])
    }
    write("$max")
    close()
}
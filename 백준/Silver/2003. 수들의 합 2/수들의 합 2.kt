private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val prefix = IntArray(N + 1)
    var count = 0
    for (i in nums.indices) {
        prefix[i + 1] = nums[i] + prefix[i]
    }
    for (i in prefix.indices) {
        for (j in i until prefix.size) {
            if (prefix[j] - prefix[i] == M) count++
        }
    }
    write("$count")
    close()
}
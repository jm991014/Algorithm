private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val prefix = IntArray(N + 1)
    for (i in nums.indices) {
        prefix[i + 1] = nums[i] + prefix[i]
    }
    repeat(M) {
        val (from, to) = br.readLine().split(" ").map { it.toInt() }
        write("${prefix[to] - prefix[from - 1]}\n")
    }
    close()
}
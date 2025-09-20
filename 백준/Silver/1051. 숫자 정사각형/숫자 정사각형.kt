private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val (N, M) = br.readLine().trim().split(" ").map(String::toInt)
    val nums = Array(N) { br.readLine() }

    for (i in (N.coerceAtMost(M)) downTo 1) {
        for (j in 0..N - i) {
            for (k in 0..M - i) {
                if (nums[j][k] == nums[j][k + i - 1] && nums[j][k] == nums[j + i - 1][k] && nums[j][k] == nums[j + i - 1][k + i - 1]) {
                    println(i * i)
                    return
                }
            }
        }
    }
}

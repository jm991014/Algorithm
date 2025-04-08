private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val numbers = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    for (i in 1 until N) {
        for (j in 0..i) {
            when (j) {
                0 -> numbers[i][j] += numbers[i - 1][j]
                i -> numbers[i][j] += numbers[i - 1][j - 1]
                else -> numbers[i][j] += numbers[i - 1][j].coerceAtLeast(numbers[i - 1][j - 1])
            }
        }
    }
    write("${numbers[N - 1].maxOf { it }}")
    close()
}
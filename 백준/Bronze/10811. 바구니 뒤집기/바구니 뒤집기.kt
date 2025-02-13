private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val basket = IntArray(N) { i -> i + 1}
    repeat(M) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        basket.reverse(i - 1, j)
    }
    write(basket.joinToString(" "))
    close()
}
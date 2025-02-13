private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val basket = IntArray(N) { i -> i + 1}
    repeat(M) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        val tmp = basket[i - 1]
        basket[i - 1] = basket[j - 1]
        basket[j - 1] = tmp
    }
    write(basket.joinToString(" "))
    close()
}
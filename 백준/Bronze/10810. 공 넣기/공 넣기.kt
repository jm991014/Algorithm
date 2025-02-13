private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val basket = IntArray(N)
    repeat(M) {
        val (i, j, k) = br.readLine().split(" ").map { it.toInt() }
        (i..j).map { basket[it - 1] = k }
    }
    write(basket.joinToString(" "))
    close()
}
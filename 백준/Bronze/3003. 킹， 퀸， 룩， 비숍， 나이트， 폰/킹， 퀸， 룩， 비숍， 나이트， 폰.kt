private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val chess = intArrayOf(1, 1, 2, 2, 2, 8)
    write(br.readLine().split(" ").mapIndexed { index, num -> chess[index] - num.toInt() }.joinToString(" "))
    close()
}
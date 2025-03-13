private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, k) = br.readLine().split(" ").map { it.toInt() }
    write("${br.readLine().split(" ").map { it.toInt() }.sortedDescending()[k - 1]}")
    close()
}
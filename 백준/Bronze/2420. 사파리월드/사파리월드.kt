import kotlin.math.abs

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toLong() }
    write("${abs(N - M)}")
    close()
}

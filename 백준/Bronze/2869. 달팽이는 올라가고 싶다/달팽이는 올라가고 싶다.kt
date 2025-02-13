import kotlin.math.ceil

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (A, B, V) = br.readLine().split(" ").map { it.toDouble() }
    write("${ceil((V - B) / (A - B)).toInt()}")
    close()
}
import kotlin.math.pow

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    write("${(2.0.pow(br.readLine().toDouble()) + 1).pow(2).toInt()}")
    close()
}

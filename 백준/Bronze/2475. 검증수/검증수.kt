import kotlin.math.pow

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val unique = br.readLine().split(" ").map { it.toDouble().pow(2) }
    write("${unique.reduce { total, num -> total + num }.toInt() % 10}")
    close()
}
import kotlin.math.abs

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    val (c, d) = br.readLine().split(" ").map { it.toInt() }
    val t = br.readLine().toInt()

    val minDist = abs(a - c) + abs(b - d)
    if (t >= minDist && (t - minDist) % 2 == 0) write("Y") else write("N")

    close()
}
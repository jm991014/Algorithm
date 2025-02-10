import kotlin.math.pow

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    while(true) {
        val (a, b, c) = br.readLine().split(" ").map { it.toDouble() }.sorted()
        if (a == 0.0 || b == 0.0 || c == 0.0) break
        write("${if (a.pow(2) + b.pow(2) == c.pow(2)) "right" else "wrong"}\n")
    }
    close()
}
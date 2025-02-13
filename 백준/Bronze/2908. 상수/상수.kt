private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (A, B) = br.readLine().split(" ").map { it.reversed().toInt() }
    write("${A.coerceAtLeast(B)}")
    close()
}
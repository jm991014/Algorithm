private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (A, B) = br.readLine().split(" ").map { it.toInt() }
    write("${(A + B) * (A - B)}")
    close()
}
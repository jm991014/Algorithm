private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, B) = br.readLine().split(" ")
    write("${N.toInt(B.toInt())}")
    close()
}
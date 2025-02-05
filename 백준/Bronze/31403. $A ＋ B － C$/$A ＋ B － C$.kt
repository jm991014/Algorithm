private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val A = br.readLine()
    val B = br.readLine()
    val C = br.readLine()
    write("${A.toInt() + B.toInt() - C.toInt()}\n")
    write("${(A + B).toInt() - C.toInt()}")
    close()
}
private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val A = br.readLine().toBigInteger()
    val B = br.readLine().toBigInteger()
    write("${A + B}\n${A - B}\n${A * B}")
    close()
}
private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toBigInteger() }
    write("${n / m}\n${n % m}")
    close()
}
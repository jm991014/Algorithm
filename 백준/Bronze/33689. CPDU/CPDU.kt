private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val names = Array(br.readLine().toInt()) { br.readLine() }
    write("${names.filter { it.startsWith("C") }.size}")
    close()
}
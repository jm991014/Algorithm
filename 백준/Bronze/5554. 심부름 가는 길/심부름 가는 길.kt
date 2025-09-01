private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val time = Array(4) { br.readLine().toInt() }.sum()
    write("${time / 60}\n${time % 60}")
    close()
}

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    write(br.readLine().map { it.digitToInt() }.sortedDescending().toIntArray().joinToString(""))
    close()
}
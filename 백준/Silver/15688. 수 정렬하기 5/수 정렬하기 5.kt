private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val arr = IntArray(br.readLine().toInt()) { br.readLine().toInt() }
    arr.sort()
    arr.forEach { write("$it\n") }
    close()
}
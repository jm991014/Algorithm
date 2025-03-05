private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    write("${br.readLine().toInt()}\n1")
    close()
}
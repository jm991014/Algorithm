private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val num = br.readLine().toInt()
    write("${(num / 5 + num / 25 + num / 125)}")
    close()
}
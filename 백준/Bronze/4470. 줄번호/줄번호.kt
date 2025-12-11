private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        write("${it + 1}. ${br.readLine()}\n")
    }
    close()
}
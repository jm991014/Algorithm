private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val str = br.readLine()
        write("${str.first()}${str.last()}\n")
    }
    close()
}
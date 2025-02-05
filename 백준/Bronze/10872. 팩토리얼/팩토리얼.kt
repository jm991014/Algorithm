private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    write("${(1..br.readLine().toInt()).fold(1) { total, num -> total * num }}")
    close()
}
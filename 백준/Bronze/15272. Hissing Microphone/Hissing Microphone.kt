private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val input = br.readLine()
    write(if (input.contains("ss")) "hiss" else "no hiss")
    close()
}

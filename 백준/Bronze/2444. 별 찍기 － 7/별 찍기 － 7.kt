private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()

    for (i in 1..n) {
        repeat(n - i) { write(" ") }
        for (j in 0 until i * 2 - 1) write("*")
        write("\n")
    }
    for (i in n - 1 downTo 1) {
        repeat(n - i) { write(" ") }
        for (j in 0 until i * 2 - 1) write("*")
        write("\n")
    }
    close()
}
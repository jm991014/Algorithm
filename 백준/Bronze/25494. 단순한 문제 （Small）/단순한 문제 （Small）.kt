private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        write("${a.coerceAtMost(b.coerceAtMost(c))}\n")
    }
    close()
}
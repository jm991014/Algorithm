private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, x, y) = br.readLine().split(" ").map(String::toInt)
    repeat(n) {
        write("${ ((br.readLine().toInt() / x.toDouble()) * y).toInt()}\n")
    }
    close()
}

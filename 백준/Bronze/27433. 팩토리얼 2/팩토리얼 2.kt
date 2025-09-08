private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var result = 1L
    (2..br.readLine().toInt()).forEach {
        result *= it
    }
    write("$result")
    close()
}

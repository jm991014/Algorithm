private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val num = br.readLine().toInt() * br.readLine().toInt() * br.readLine().toInt()
    repeat(10) { digit ->
        write("${num.toString().count { it == digit.digitToChar() }}\n")
    }
    close()
}
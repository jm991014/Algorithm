private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    write(br.readLine().map { if (it.isUpperCase()) it.lowercase() else it.uppercase() }.joinToString(""))
    close()
}

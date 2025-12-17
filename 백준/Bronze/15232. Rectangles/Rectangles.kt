private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val R = br.readLine().toInt()
    val C = br.readLine().toInt()

    repeat(R) {
        repeat(C) {
            write("*")
        }
        newLine()
    }
    close()
}
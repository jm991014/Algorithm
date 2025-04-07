private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    write(if(N % 2 == 1)"SK" else "CY")
    close()
}
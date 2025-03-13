private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    var num = 666
    var count = 0
    while (true) {
        if (count == N) break
        if (num.toString().contains("666")) count++
        num++
    }
    write("${num - 1}")
    close()
}
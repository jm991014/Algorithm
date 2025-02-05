private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val (H, W, N) = br.readLine().split(" ").map { it.toInt() }
        val floor = if (N % H == 0) H else N % H
        val room = if (N % H == 0) N / H else N / H + 1
        write("${floor}%02d\n".format(room))
    }
    close()
}
private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val shirts = br.readLine().split(" ").map { it.toInt() }
    val (T, P) = br.readLine().split(" ").map { it.toInt() }
    write("${shirts.fold(0) { total, num -> total + (num + T - 1) / T }}\n${N / P} ${N % P}")
    close()
}
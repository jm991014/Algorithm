private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var (a, b, c) = br.readLine().split(" ").map { it.toLong() }
    var result = 1L
    while (b > 0) {
        if (b % 2 == 1L) result = (result * a) % c
        a = (a * a) % c
        b /= 2
    }
    write("$result")
    close()
}
private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        var leftOver = a % 10

        repeat(b - 1) {
            leftOver *= a
            leftOver %= 10
        }
        if (leftOver == 0) write("10\n") else write("$leftOver\n")
    }
    close()
}
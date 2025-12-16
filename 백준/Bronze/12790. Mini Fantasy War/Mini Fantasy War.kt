private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val input = br.readLine().split(" ").map { it.toInt() }
        val hp = (input[0] + input[4]).coerceAtLeast(1)
        val mp = (input[1] + input[5]).coerceAtLeast(1)
        val atk = (input[2] + input[6]).coerceAtLeast(0)
        val def = input[3] + input[7]
        val result = 1 * hp + 5 * mp + 2 * atk + 2 * def
        write("${result}\n")
    }
    close()
}
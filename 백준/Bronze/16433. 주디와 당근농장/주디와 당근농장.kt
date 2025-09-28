private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val (N, R, C) = br.readLine().split(" ").map { it.toInt() }
    var isOdd = (R + C) % 2 == 1

    repeat(N) {
        repeat(N) {
            if (isOdd) append(".") else append("v")
            isOdd = !isOdd
        }
        appendLine()

        if (N % 2 == 0) isOdd = !isOdd
    }
    print(this)
}
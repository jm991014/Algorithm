private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val bus = Array(n) { IntArray(n) { 10000001 } }.apply {
        repeat(n) {
            this[it][it] = 0
        }
    }

    repeat (m) {
        val (start, end, cost) = br.readLine().split(" ").map { it.toInt() }
        if (bus[start - 1][end - 1] > cost) bus[start - 1][end - 1] = cost
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            for (k in 0 until n) {
                bus[j][k] = bus[j][k].coerceAtMost(bus[j][i] + bus[i][k])
            }
        }
    }

    repeat (n) {
        append(bus[it].map { if (it == 10000001) 0 else it }.joinToString(" "))
        appendLine()
    }
    print(this)
}

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, d, k, c) =  br.readLine().split(" ").map { it.toInt() }
    val table = IntArray(N) { br.readLine().toInt() }
    val sushi = IntArray(d + 1)
    var max = 0
    var cnt = 0

    for (i in 0 until k) {
        val dish = table[i]
        if (sushi[dish] == 0) cnt++
        sushi[dish]++
    }
    max = if (sushi[c] == 0) cnt + 1 else cnt

    for (i in 1 until N) {
        val before = table[(i - 1) % N]
        sushi[before]--
        if (sushi[before] == 0) cnt--

        val current = table[(i + k - 1) % N]
        if (sushi[current] == 0) cnt++
        sushi[current]++

        val locMax = if (sushi[c] == 0) cnt + 1 else cnt
        if (locMax > max) max = locMax
    }

    write("$max")
    close()
}
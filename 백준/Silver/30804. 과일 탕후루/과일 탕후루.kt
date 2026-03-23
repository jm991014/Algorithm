private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val S = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var start = 0
    val counts = IntArray(10)
    var fruits = 0
    var maxFruit = 0

    for (end in S.indices) {
        val endFruit = S[end]
        if (counts[endFruit] == 0 ) fruits++
        counts[endFruit]++

        while (fruits > 2) {
            val startFruit = S[start]
            counts[startFruit]--

            if (counts[startFruit] == 0) fruits--
            start++
        }

        maxFruit = maxFruit.coerceAtLeast(end - start + 1)
    }

    write("$maxFruit")
    close()
}
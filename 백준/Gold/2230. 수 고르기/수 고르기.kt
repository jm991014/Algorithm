private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val sequence = ArrayList<Int>()
    repeat(N) { sequence.add(br.readLine().toInt()) }
    sequence.sort()

    var start = 0
    var end = 0
    var max = Int.MAX_VALUE

    while(end in start until N) {
        val diff = sequence[end] - sequence[start]
        if (diff < M) end++
        else {
            max = minOf(max, diff)
            start++
        }
    }
    write("$max")
    close()
}
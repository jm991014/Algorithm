private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M, B) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    var minTime = Int.MAX_VALUE
    var bestHeight = -1

    for (i in 256 downTo 0) {
        val (time, height) = board.grand(B, i)

        if (height == -1) continue

        if (time < minTime) {
            minTime = time
            bestHeight = height
        }
    }

    write("$minTime $bestHeight")
    close()
}

fun Array<IntArray>.grand(B: Int, targetHeight: Int): Pair<Int, Int> {
    var totalTime = 0
    var currentBlocks = B.toLong()

    for (row in this) {
        for (cell in row) {
            val diff = cell - targetHeight
            if (diff > 0) {
                totalTime += diff * 2
                currentBlocks += diff
            } else if (diff < 0) {
                val toFill = -diff
                totalTime += toFill
                currentBlocks -= toFill
            }
        }
    }

    return if (currentBlocks < 0) Int.MAX_VALUE to -1
        else totalTime to targetHeight
}
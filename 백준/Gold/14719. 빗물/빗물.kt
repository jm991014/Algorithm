private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (H, W) = br.readLine().split(" ").map { it.toInt() }
    val blocks = br.readLine().split(" ").map { it.toInt() }
    var totalDrops = 0

    for (i in 1 until W - 1) {
        val leftMax = blocks.subList(0, i).maxOrNull() ?: 0
        val rightMax = blocks.subList(i + 1, W).maxOrNull() ?: 0
        val minHeight = minOf(leftMax, rightMax)

        if (blocks[i] < minHeight) {
            totalDrops += minHeight - blocks[i]
        }
    }

    write("$totalDrops")
    close()
}

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").let { it[0].toInt() to it[1].toLong() }
    val trees = br.readLine().split(" ").map { it.toLong() }.toLongArray()

    trees.sort()

    var left = 0L
    var right = trees.last()

    while (left <= right) {
        val mid = (left + right) / 2
        if (trees.chopTree(mid) >= M) left = mid + 1
        else right = mid - 1
    }
    write("$right")
    close()
}

private fun LongArray.chopTree(height: Long): Long {
    var sum = 0L

    this.forEach { tree ->
        if (tree > height) sum += tree - height
    }
    return sum
}
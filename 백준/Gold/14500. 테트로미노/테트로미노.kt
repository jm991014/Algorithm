private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val blocks = arrayOf(
        arrayOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(3, 0)),
        arrayOf(Pair(0, 0), Pair(1, 0), Pair(0, 1), Pair(1, 1)),
        arrayOf(Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(1, 2)),
        arrayOf(Pair(0, 0), Pair(0, 1), Pair(1, 1), Pair(1, 2)),
        arrayOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(1, 1))
    )
    val allShapes = mutableListOf<Array<Pair<Int, Int>>>()

    blocks.forEach {
        var curr = it
        repeat(4) {
            allShapes.add(curr)
            curr = curr.rotate()
        }

        var flipped = it.flip()
        repeat(4) {
            allShapes.add(flipped)
            flipped = flipped.rotate()
        }
    }

    var maxScore = 0

    for (i in 0 until N) {
        for (j in 0 until M) {
            allShapes.forEach {
                maxScore = board.check(it, Pair(i, j)).coerceAtLeast(maxScore)
            }
        }
    }
    write("$maxScore")
    close()
}
fun Array<IntArray>.check(block: Array<Pair<Int, Int>>, index: Pair<Int, Int>): Int {
    if (block.all { it.first + index.first in 0 until size } && block.all { it.second + index.second in 0 until this[0].size }) {
        return block.sumOf { this[it.first + index.first][it.second + index.second] }
    }
    return 0
}

fun Array<Pair<Int, Int>>.rotate() = map { Pair(it.second, -it.first) }.toTypedArray()

fun Array<Pair<Int, Int>>.flip() = map { Pair(it.first, -it.second) }.toTypedArray()

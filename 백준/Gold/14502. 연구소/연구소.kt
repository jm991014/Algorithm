import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private val virus = mutableListOf<Pair<Int, Int>>()
private var maxSpace = 0

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val lab = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (lab[i][j] == 2) virus.add(Pair(i, j))
        }
    }

    lab.getWallCombination(mutableSetOf()) // combination 구하기

    println(maxSpace)
}

private fun Array<IntArray>.getWallCombination(walls: MutableSet<Pair<Int, Int>>) {
    if (walls.size == 3) {
        this.bfs(walls.toSet(), virus)
        return
    }
    for (i in this.indices) {
        for (j in this[0].indices) {
            if (!walls.contains(Pair(i, j)) && this[i][j] == 0) {
                walls.add(Pair(i, j))
                this.getWallCombination(walls)
                walls.remove(Pair(i, j))
            }
        }
    }
}

private fun Array<IntArray>.bfs(walls: Set<Pair<Int, Int>>, virus: MutableList<Pair<Int, Int>>) {
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    val queue = LinkedList<Pair<Int, Int>>().apply { virus.forEach { offer(it) } }

    val clonedLab = Array(this.size) { row -> this[row].copyOf() } // deep copy를 하려면 행 단위로 해야함

    walls.forEach {
        clonedLab[it.first][it.second] = 1
    }

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()

        for (dir in directions) {
            val dx = x + dir.first
            val dy = y + dir.second

            if (dx in clonedLab.indices && dy in clonedLab[0].indices && clonedLab[dx][dy] == 0) {
                queue.offer(Pair(dx, dy))
                clonedLab[dx][dy] = 2
            }
        }
    }
    maxSpace = maxSpace.coerceAtLeast(clonedLab.sumOf { it.count { it == 0 } })
}

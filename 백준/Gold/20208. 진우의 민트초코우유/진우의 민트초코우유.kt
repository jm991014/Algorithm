import kotlin.math.abs

private val br = System.`in`.bufferedReader()
private lateinit var home: Pair<Int, Int>
private var milks = mutableListOf<Pair<Int, Int>>()
private var totalMilk = 0

fun main() = with(System.out.bufferedWriter()) {
    val (N, M, H) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    for (i in 0 until N) {
        for (j in 0 until N) {
            if (map[i][j] == 1) home = i to j
            if (map[i][j] == 2) milks.add(i to j)
        }
    }
    val visited = BooleanArray(milks.size)

    map.findMintChocoMilk(home, M, H, 0, visited)

    write("$totalMilk")
    close()
}

private fun Array<IntArray>.findMintChocoMilk(current: Pair<Int, Int>, hp: Int, recovery: Int, count: Int, visited: BooleanArray) {
    if (hp.getDistance(current, home) >= 0) totalMilk = totalMilk.coerceAtLeast(count)

    for (i in milks.indices) {
        val next = milks[i]
        val hpLeft = hp.getDistance(current, next)
        if (!visited[i] && hpLeft >= 0) {
            visited[i] = true
            this.findMintChocoMilk(next, hpLeft + recovery, recovery, count + 1, visited)
            visited[i] = false
        }
    }
}

private fun Int.getDistance(from: Pair<Int, Int>, to: Pair<Int, Int>) =
    this - (abs(from.first - to.first) + abs(from.second - to.second))

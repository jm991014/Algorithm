import kotlin.math.abs

private val br = System.`in`.bufferedReader()
private val house = mutableListOf<Pair<Int, Int>>()
private val chicken = mutableListOf<Pair<Int, Int>>()
private var minDist = Int.MAX_VALUE

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val city = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    for (i in city.indices) {
        for (j in city[0].indices) {
            if (city[i][j] == 1) house.add(Pair(i, j))
            if (city[i][j] == 2) chicken.add(Pair(i, j))
        }
    }

    chicken.getCombination(0, chicken.size - M, mutableSetOf())

    write("$minDist")
    close()
}

private fun MutableList<Pair<Int, Int>>.getCombination(index: Int, toClose: Int, combination: MutableSet<Pair<Int, Int>>) {
    if (combination.size == toClose) {
        combination.toSet().checkDistance()
        return
    }

    for (i in index until this.size) {
        combination.add(this[i])
        this.getCombination(i + 1, toClose, combination)
        combination.remove(this[i])
    }
}

private fun Set<Pair<Int, Int>>.checkDistance() {
    var total = 0
    val clonedChicken = chicken - this

    for (i in house.indices) {
        var min = Int.MAX_VALUE
        for (j in clonedChicken.indices) {
            min = min.coerceAtMost(abs(house[i].first - clonedChicken[j].first) + abs(house[i].second - clonedChicken[j].second))
        }
        total += min
    }
    minDist = minDist.coerceAtMost(total)
}

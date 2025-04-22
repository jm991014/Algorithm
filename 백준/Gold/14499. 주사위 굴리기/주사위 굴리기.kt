private val br = System.`in`.bufferedReader()
private val directions = arrayOf(Pair(0, 1), Pair(0, -1), Pair(-1, 0), Pair(1, 0))

private data class Dice(var x: Int, var y: Int, var one: Int, var two: Int, var three: Int, var four: Int, var five: Int, var six: Int)

fun main() = with(System.out.bufferedWriter()) {
    val (N, M, x, y, K) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val command = br.readLine().split(" ").map { it.toInt() - 1 }.toIntArray()
    val dice = Dice(x, y, 0, 0, 0, 0, 0, 0)

    command.forEach {
        val dx = dice.x + directions[it].first
        val dy = dice.y + directions[it].second

        if (dx !in 0 until N || dy !in 0 until M) return@forEach

        dice.x = dx
        dice.y = dy
        dice.moveDice(it)
        write("${dice.one}\n")

        if (map[dx][dy] == 0) map[dx][dy] = dice.six
        else {
            dice.six = map[dx][dy]
            map[dx][dy] = 0
        }
    }
    close()
}

private fun Dice.moveDice(dir: Int) {
    val bottom = this.one

    when (dir) {
        0 -> {
            this.one = this.four
            this.four = this.six
            this.six = this.three
            this.three = bottom
        }
        1 -> {
            this.one = this.three
            this.three = this.six
            this.six = this.four
            this.four = bottom
        }
        2 -> {
            this.one = this.five
            this.five = this.six
            this.six = this.two
            this.two = bottom
        }
        3 -> {
            this.one = this.two
            this.two = this.six
            this.six = this.five
            this.five = bottom
        }
    }
}
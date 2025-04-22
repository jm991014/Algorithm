import kotlin.math.pow

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val gear = Array(4) { br.readLine().map { it.digitToInt() }.toIntArray() }
    val K = br.readLine().toInt()
    val command = Array(K) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    var score = 0

    command.forEach {
        val visited = BooleanArray(4)
        val gearNum = it[0] - 1
        val direction = it[1]
        moveGear(gearNum, direction, gear, visited)
    }

    repeat(4) {
        if (gear[it][0] == 1) score += 2.0.pow(it).toInt()
    }

    write("$score")
    close()
}

private fun moveGear(gearNum: Int, direction: Int, gear: Array<IntArray>, visited: BooleanArray) {
    if (visited[gearNum]) return
    visited[gearNum] = true

    if (gearNum >= 1 && gear[gearNum - 1][2] != gear[gearNum][6]) moveGear(gearNum - 1, direction * -1, gear, visited)
    if (gearNum <= 2 && gear[gearNum][2] != gear[gearNum + 1][6]) moveGear(gearNum + 1, direction * -1, gear, visited)

    when(direction) {
        1 -> {
            val last = gear[gearNum][7]
            for (i in 7 downTo 1) gear[gearNum][i] = gear[gearNum][i - 1]
            gear[gearNum][0] = last
        }
        -1 -> {
            val first = gear[gearNum][0]
            for (i in 0..6) gear[gearNum][i] = gear[gearNum][i + 1]
            gear[gearNum][7] = first
        }
    }
}

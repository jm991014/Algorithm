import kotlin.math.abs

private val br = System.`in`.bufferedReader()
private val positions = mutableSetOf<Pos>().apply { add(Pos(0, 0)) }
private val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))

private data class Pos(var x: Int, var y: Int)

fun main() = with(System.out.bufferedWriter()) {
    val s = br.readLine().toInt()
    val commands = br.readLine().toCharArray()
    var dir = 0
    val current = Pos(0, 0)

    commands.forEach { c ->
        when (c) {
            'R' -> dir = (dir + 1) % 4
            'L' -> dir = (dir + 3) % 4
            else -> {
                current.x += directions[dir].first
                current.y += directions[dir].second
                positions.add(Pos(current.x, current.y))
            }
        }
    }

    val minX = positions.minOf { it.x }
    val minY = positions.minOf { it.y }

    positions.forEach {
        it.x += abs(minX)
        it.y += abs(minY)
    }

    val maxX = positions.maxOf { it.x }
    val maxY = positions.maxOf { it.y }

    val maze = Array(maxX + 1) { CharArray(maxY + 1) { '#' } }
    positions.forEach {
        maze[it.x][it.y] = '.'
    }
    maze.forEach {
        write("${it.joinToString("")}\n")
    }
    close()
}
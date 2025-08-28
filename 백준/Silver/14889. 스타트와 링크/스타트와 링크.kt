import kotlin.math.abs

private val br = System.`in`.bufferedReader()
private var result = Int.MAX_VALUE

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val team = Array(N) { br.readLine().split(" ").map(String::toInt).toIntArray() }
    val visited = BooleanArray(N)

    team.dfs(0, 0, visited)
    write("$result")
    close()
}

fun Array<IntArray>.dfs(depth: Int, current: Int, visited: BooleanArray) {
    if (depth == size / 2) {
        calculate(visited)
        return
    }

    for (i in current until size) {
        if (!visited[i]) {
            visited[i] = true
            dfs(depth + 1, i + 1, visited)
            visited[i] = false
        }
    }
}

fun Array<IntArray>.calculate(visited: BooleanArray) {
    var start = 0
    var link = 0

    for (i in 0 until size - 1) {
        for (j in i until size) {
            when {
                visited[i] && visited[j] -> {
                    start += this[i][j]
                    start += this[j][i]
                }

                !visited[i] && !visited[j] -> {
                    link += this[i][j]
                    link += this[j][i]
                }
            }
        }
    }

    result = abs(start - link).coerceAtMost(result)
}
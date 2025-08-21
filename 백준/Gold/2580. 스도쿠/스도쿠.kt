private val br = System.`in`.bufferedReader()
private var rowVisited = Array(10){ BooleanArray(10) }
private var colVisited = Array(10){ BooleanArray(10) }
private var boxVisited = Array(10){ BooleanArray(10) }

fun main() = with(System.out.bufferedWriter()) {
    val sudoku = Array(9) { br.readLine().split(" ").map(String::toInt).toIntArray() }
    val blank = mutableListOf<Pair<Int, Int>>()

    for (i in sudoku.indices) {
        for (j in sudoku[i].indices) {
            if (sudoku[i][j] == 0) {
                blank.add(i to j)
            } else {
                rowVisited[i][sudoku[i][j]] = true
                colVisited[j][sudoku[i][j]] = true
                boxVisited[3 * (i / 3) + j / 3][sudoku[i][j]] = true
            }
        }
    }

    sudoku.dfs(0, blank)

    repeat(9) {
        write("${sudoku[it].joinToString(" ")}\n")
    }
    close()
}

fun Array<IntArray>.dfs(depth: Int, blank: MutableList<Pair<Int, Int>>): Boolean {
    if (depth == blank.size) return true

    val (x, y) = blank[depth]
    val box = 3 * (x / 3) + y / 3
    for (i in 1 until 10) {
        if(!rowVisited[x][i] && !colVisited[y][i] && !boxVisited[box][i]){
            rowVisited[x][i] = true
            colVisited[y][i] = true
            boxVisited[box][i] = true
            this[x][y] = i

            if (dfs(depth + 1, blank)) return true

            rowVisited[x][i] = false
            colVisited[y][i] = false
            boxVisited[box][i] = false
            this[x][y] = 0
        }
    }
    return false
}

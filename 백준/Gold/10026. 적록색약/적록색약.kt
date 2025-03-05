private val br = System.`in`.bufferedReader()

var area = 0
var area2 = 0

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val image = Array(N) { br.readLine().toCharArray() }
    val image2 = image.map { it.joinToString("").replace("R", "G").toCharArray() }.toTypedArray()
    val visited = Array(N) { BooleanArray(N) }
    val visited2 = Array(N) { BooleanArray(N) }
    for (i in image.indices) {
        for (j in image[0].indices) {
            if (!visited[i][j]) {
                area++
                dfs(i, j, image, visited)
            }
            if (!visited2[i][j]) {
                area2++
                dfs(i, j, image2, visited2)
            }
        }
    }
    write("$area $area2")
    close()
}

fun dfs(x: Int, y: Int, image: Array<CharArray>, visited: Array<BooleanArray>) {
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    visited[x][y] = true

    for (direction in directions) {
        val dx = x + direction.first
        val dy = y + direction.second
        if (dx in image.indices && dy in image[0].indices && !visited[dx][dy] && image[x][y] == image[dx][dy]) dfs(dx, dy, image, visited)
    }
}
private val br = System.`in`.bufferedReader()
private var white = 0
private var blue = 0

fun main() = with(System.out.bufferedWriter()) {
    val paper = Array(br.readLine().toInt()) { br.readLine().split(" ").map(String::toInt).toIntArray() }

    paper.divide(paper.size, 0, 0)
    write("$white\n$blue")
    close()
}

fun Array<IntArray>.divide(size: Int, x: Int, y: Int) {
    if (size == 1 || this.check(size, x, y)) {
        if (this[x][y] == 1) blue++ else white++
    } else {
        divide(size / 2, x, y)
        divide(size / 2, x + size / 2, y)
        divide(size / 2, x, y + size / 2)
        divide(size / 2, x + size / 2, y + size / 2)
    }
}

fun Array<IntArray>.check(size: Int, x: Int, y: Int): Boolean {
    val color = this[x][y]

    for (i in x until x + size) {
        for (j in y until y + size) {
            if (this[i][j] != color) return false
        }
    }
    return true
}
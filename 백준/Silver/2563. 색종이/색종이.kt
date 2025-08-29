private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val input = Array(br.readLine().toInt()) { br.readLine().split(" ").map(String::toInt).let { it[0] - 1 to it[1] - 1 } }
    val paper = Array(100) { IntArray(100) }

    input.forEach {
        for (i in it.first until it.first + 10) {
            for (j in it.second until it.second + 10) {
                paper[i][j] = 1
            }
        }
    }
    var ans = 0
    paper.forEach {
        ans += it.count { it == 1 }
    }
    write("$ans")
    close()
}
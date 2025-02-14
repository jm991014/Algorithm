private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (row, col) = br.readLine().split(" ").map { it.toInt() }
    val binomial = Array(12) { IntArray(12) { 1 } }
    for (i in 1..11) {
        for (j in 1..i) {
            binomial[i][j] = binomial[i - 1][j - 1] + binomial[i - 1][j]
        }
    }
    print(binomial[row - 1][col])
}
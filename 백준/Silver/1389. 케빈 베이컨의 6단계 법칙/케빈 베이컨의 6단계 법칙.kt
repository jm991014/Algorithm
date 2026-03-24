private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map(String::toInt)
    val relation = Array(N + 1) { IntArray(N + 1) { 500001 } }.apply {
        (0..N).forEach { this[it][it] = 0 }
    }

    repeat(M) {
        val (A, B) = br.readLine().split(" ").map(String::toInt)
        relation[A][B] = 1
        relation[B][A] = 1
    }

    for (k in 1..N) {
        for (i in 1..N) {
            for (j in 1..N) {
                if (relation[i][j] > relation[i][k] + relation[k][j]) {
                    relation[i][j] = relation[i][k] + relation[k][j]
                }
            }
        }
    }

    var minBacon = 500001
    var winner = 0

    for (i in 1..N) {
        var sum = 0
        for (j in 1..N) {
            sum += relation[i][j]
        }

        if (sum < minBacon) {
            minBacon = sum
            winner = i
        }
    }

    write("$winner")
    close()
}
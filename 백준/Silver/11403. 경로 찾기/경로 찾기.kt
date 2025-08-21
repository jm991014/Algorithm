private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val graph = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    for (i in 0 until N) {
        for (j in 0 until N) {
            for (k in 0 until N) {
                if (graph[j][k] == 0 && graph[j][i] == 1 && graph[i][k] == 1) graph[j][k] = 1
            }
        }
    }
    repeat(N) {
        write("${graph[it].joinToString(" ")}\n")
    }
    close()
}

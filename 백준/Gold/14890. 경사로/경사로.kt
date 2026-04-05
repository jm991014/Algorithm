import kotlin.math.abs

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val (N, L) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(N) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    var sum = 0

    for (i in 0 until N) {
        if (graph[i].check(L)) sum++
        if (IntArray(N) { graph[it][i] }.check(L)) sum++
    }

    bw.write("$sum\n")
    bw.close()
}

fun IntArray.check(L: Int): Boolean {
    val visited = BooleanArray(size)

    for (i in 0 until size - 1) {
        if (this[i] == this[i + 1]) continue

        if (abs(this[i] - this[i + 1]) > 1) return false

        if (this[i] + 1 == this[i + 1]) {
            for (j in i downTo i - L + 1) {
                if (j < 0 || this[j] != this[i] || visited[j]) return false
                visited[j] = true
            }
        }
        else if (this[i] - 1 == this[i + 1]) {
            for (j in i + 1..i + L) {
                if (j >= size || this[j] != this[i + 1] || visited[j]) return false
                visited[j] = true
            }
        }
    }
    return true
}
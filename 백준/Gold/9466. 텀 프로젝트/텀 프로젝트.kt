private val br = System.`in`.bufferedReader()
private var count = 0

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val n = br.readLine().toInt()
        val students = br.readLine().split(" ").map { it.toInt() - 1 }.toIntArray()
        val finished = BooleanArray(n)
        val visited = BooleanArray(n)

        for (i in 0 until n) {
            if (!visited[i]) students.dfs(i, finished, visited)
        }

        write("${n - count}\n")
        count = 0
    }
    close()
}

private fun IntArray.dfs(student: Int, finished: BooleanArray, visited: BooleanArray) {
    visited[student] = true
    val next = this[student]

    if (!visited[next]) dfs(next, finished, visited)

    if (visited[student] && !finished[next]) {
        var tmp = next
        while (tmp != student) {
            count++
            tmp = this[tmp]
        }
        count++
    }
    finished[student] = true
}

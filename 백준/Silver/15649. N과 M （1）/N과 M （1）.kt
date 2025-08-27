private val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map(String::toInt)
    val arr = IntArray(M)
    val visited = BooleanArray(N)

    arr.getPermutation(0, N, M, visited)
    println(sb.toString())
}

fun IntArray.getPermutation(depth: Int, N: Int, M: Int, visited: BooleanArray) {
    if (depth == M) {
        sb.append(this.joinToString(" ", postfix = "\n"))
        return
    }

    for (i in 0 until N) {
        if (!visited[i]) {
            visited[i] = true
            this[depth] = i + 1
            this.getPermutation(depth + 1, N, M, visited)
            visited[i] = false
        }
    }
}
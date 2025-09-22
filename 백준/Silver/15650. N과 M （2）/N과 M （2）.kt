private val br = System.`in`.bufferedReader()
private val sb = StringBuilder()

fun main() {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val arr = IntArray(M)

    arr.getCombination(0, 0, N, M)
    print(sb)
}

fun IntArray.getCombination(depth: Int, start: Int, N: Int, M: Int) {
    if (depth == M) {
        sb.append(this.joinToString(" ", postfix = "\n"))
        return
    }

    for (i in start until N) {
        this[depth] = i + 1
        this.getCombination(depth + 1, i + 1, N, M)
    }
}
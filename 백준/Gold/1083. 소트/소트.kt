private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val N = br.readLine().toInt()
    val A = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var S = br.readLine().toInt()
    for (i in 0 until N) {
        if (S == 0) break

        var maxVal = A[i]
        var maxIdx = i

        for (j in i + 1..(i + S).coerceAtMost(N - 1)) {
            if (A[j] > maxVal) {
                maxVal = A[j]
                maxIdx = j
            }
        }

        if (maxIdx != i) {
            for (j in maxIdx downTo i + 1) {
                val tmp = A[j]
                A[j] = A[j - 1]
                A[j - 1] = tmp
            }
            S -= (maxIdx - i)
        }
    }
    println(A.joinToString(" "))
}

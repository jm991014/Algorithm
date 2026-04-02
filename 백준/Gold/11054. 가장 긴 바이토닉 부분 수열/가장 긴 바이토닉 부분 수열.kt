private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val N = br.readLine().toInt()
    val A = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val dpI = IntArray(N) { 1 }
    val dpD = IntArray(N) { 1 }

    for (i in 1 until N) {
        for (j in 0..i) {
            if (A[i] > A[j]) dpI[i] = dpI[i].coerceAtLeast(dpI[j] + 1)
        }
    }

    for (i in N - 1 downTo 0) {
        for (j in i + 1 until N) {
            if (A[i] > A[j]) dpD[i] = dpD[i].coerceAtLeast(dpD[j] + 1)
        }
    }

    var maxLength = 0
    for (k in 0 until N) {
        maxLength = maxLength.coerceAtLeast(dpI[k] + dpD[k] - 1)
    }
    bw.write("$maxLength")
    bw.close()

}
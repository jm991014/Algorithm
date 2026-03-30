private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").map { it.toInt() }.sorted().toIntArray()

    nums.permutations(IntArray(M), M, 0, 0)
    bw.close()
}

fun IntArray.permutations(arr: IntArray, M: Int, start: Int, depth: Int) {
    if (depth == M) {
        bw.write("${arr.joinToString(" ")}\n")
        return
    }

    var prev = -1

    for (i in start until size) {
        if (prev == this[i]) continue

        arr[depth] = this[i]
        prev = this[i]

        permutations(arr, M, i, depth + 1)
    }
}
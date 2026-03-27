private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    permutations(mutableListOf(), N, M, 1)

    bw.close()
}

fun permutations(list: MutableList<Int>, N: Int, M: Int, start: Int) {
    if (list.size == M) {
        bw.write("${list.joinToString(" ")}\n")
        return
    }

    for (i in start..N) {
        list.add(i)
        permutations(list, N, M, i)
        list.removeLast()
    }
}

private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val numbers = br.readLine().split(" ").map { it.toInt() }.sorted().toIntArray()
    val visited = BooleanArray(N) { false }
    numbers.permutations(mutableListOf(), visited, M)

    bw.close()
}

fun IntArray.permutations(list: MutableList<Int>, visited: BooleanArray, M: Int) {
    if (list.size == M) {
        bw.write("${list.joinToString(" ")}\n")
        return
    }

    for (i in indices) {
        if (visited[i]) continue

        visited[i] = true
        list.add(this[i])

        permutations(list, visited, M)

        list.removeLast()
        visited[i] = false
    }
}

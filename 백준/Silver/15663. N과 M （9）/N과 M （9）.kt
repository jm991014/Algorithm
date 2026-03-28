private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()
private val set = mutableSetOf<String>()

fun main() {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val numbers = br.readLine().split(" ").map { it.toInt() }.sorted().toIntArray()
    val visited = BooleanArray(N)
    numbers.permutations(mutableListOf(), visited, M)

    set.forEach { print("$it\n") }
    bw.close()
}

fun IntArray.permutations(list: MutableList<Int>, visited: BooleanArray, M: Int) {
    if (list.size == M) {
        set.add(list.joinToString(" "))
        return
    }

    for (i in indices) {
        if (visited[i]) continue

        list.add(this[i])
        visited[i] = true

        permutations(list, visited, M)

        list.removeLast()
        visited[i] = false
    }
}

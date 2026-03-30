private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()
private val set = mutableSetOf<String>()

fun main() {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").map { it.toInt() }.sorted().toIntArray()

    for (i in nums.indices) {
        nums.permutations(mutableListOf(), M, i)
    }

    set.forEach {
        bw.write("${it}\n")
    }
    bw.close()
}

fun IntArray.permutations(list: MutableList<Int>, M: Int, start: Int) {
    if (list.size == M) {
        set.add(list.joinToString(" "))
        return
    }

    for (i in start until size) {
        list.add(this[i])
        permutations(list, M, i)
        list.removeLast()
    }
}
private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val array = IntArray(br.readLine().toInt()) { br.readLine().toInt() }.sortedArray()
    write("${Math.round((array.sum().toDouble() / array.size))}\n")
    write("${array[array.size / 2]}\n")
    write("${getFrequent(array)}\n")
    write("${array.last() - array.first()}")
    close()
}

fun getFrequent(array: IntArray): Int {
    val freq = array.groupBy { it }.mapValues { it.value.size }.toList()
        .groupBy { it.second }
        .maxBy { it.key }.value.map { it.first }
    return freq.sorted().getOrNull(1) ?: freq.first()
}
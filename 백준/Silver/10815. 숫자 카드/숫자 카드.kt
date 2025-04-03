private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val cards = br.readLine().split(" ").map { it.toInt() }.sorted().toIntArray()
    val M = br.readLine().toInt()
    val target = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    repeat(target.size) {
        if (cards.binarySearch(target[it]) < 0) write("0 ")
        else write("1 ")
    }
    close()
}
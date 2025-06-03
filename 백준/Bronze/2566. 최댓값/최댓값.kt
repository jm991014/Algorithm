private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val arr = List(9) { br.readLine().split(" ").map { it.toInt() } }
        .flatten()
        .toIntArray()
    val max = arr.maxOf { it }
    val index = arr.indexOf(max)
    write("$max\n${index / 9 + 1} ${index % 9 + 1}")
    close()
}
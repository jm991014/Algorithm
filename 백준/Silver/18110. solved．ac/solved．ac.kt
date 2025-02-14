private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val level = IntArray(n) { br.readLine().toInt()  }.sorted()
    val trim = Math.round(n.toDouble() / 100 * 15).toInt()
    val trimmedLvl = level.slice(trim until n - trim)
    write("${Math.round(trimmedLvl.sum().toDouble() / trimmedLvl.size).toInt()}")
    close()
}
private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val decomposer = br.readLine().toInt()
    var ans = 0

    for (i in 1..decomposer) if (i + i.toString().map { it.digitToInt() }.sum() == decomposer) {
        ans = i
        break
    }
    write("$ans")
    close()
}
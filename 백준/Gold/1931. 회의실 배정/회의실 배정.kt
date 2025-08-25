private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val meetings = Array(br.readLine().toInt()) { br.readLine().split(" ").let { it[0].toInt() to it[1].toInt() } }
        .sortedWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first } )

    var cnt = 0
    var end = 0
    for ((s, e) in meetings) {
        if (s >= end) {
            cnt++
            end = e
        }
    }
    write(cnt.toString())
    close()
}
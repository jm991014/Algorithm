private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val coordinate = Array(br.readLine().toInt()) { br.readLine().split(" ").map { it.toInt() }.let { (x, y) -> x to y } }
    coordinate.sortedWith(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second }).forEach {
        write("${ it.first} ${it.second}\n")
    }
    close()
}
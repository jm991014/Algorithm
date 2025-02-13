private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    br.readLine()
    val card = br.readLine().split(" ").map { it.toInt() }.groupingBy { it }.eachCount()
    br.readLine()
    br.readLine().split(" ").map { it.toInt() }.forEach {
        write("${card.getOrDefault(it, 0)} ")
    }
    close()
}
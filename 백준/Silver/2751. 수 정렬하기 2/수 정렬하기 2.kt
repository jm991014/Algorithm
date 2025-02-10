private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val num = br.readLine().toInt()
    val set = mutableSetOf<Int>()
    repeat(num) { set.add(br.readLine().toInt()) }
    set.sorted().forEach { write("$it\n") }
    close()
}
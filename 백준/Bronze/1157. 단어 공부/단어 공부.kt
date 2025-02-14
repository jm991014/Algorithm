private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val map = br.readLine().groupingBy { it.lowercase() }.eachCount()
    write("${if (map.count { it.value == map.maxOf { it.value } } > 1) "?" else map.maxByOrNull { it.value }?.key?.uppercase()}")
    close()
}
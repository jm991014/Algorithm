private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val size = br.readLine().toInt()
    val arr = br.readLine().split(" ").map(String::toInt).sorted().toIntArray()
    write("${arr.first() * arr.last()}")
    close()
}

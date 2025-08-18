private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val queue = br.readLine().split(" ").map(String::toInt).sorted()
    var sum = 0
    repeat(N) {
        sum += queue.take(it + 1).sumOf { it }
    }
    write("$sum")
    close()
}
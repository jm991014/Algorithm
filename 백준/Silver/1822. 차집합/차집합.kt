private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val A = br.readLine().split(" ").map { it.toInt() }.toSortedSet()
    val B = br.readLine().split(" ").map { it.toInt() }.toSortedSet()
    val answer = A - B
    
    write("${answer.size}\n${answer.joinToString(" ")}")
    close()
}
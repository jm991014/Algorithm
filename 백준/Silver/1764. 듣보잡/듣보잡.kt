private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val listen = Array(N) { br.readLine() }.toSet()
    val see = Array(M) { br.readLine() }.toSet()
    val listenSee = listen.intersect(see).toSortedSet()

    write("${listenSee.size}\n${listenSee.joinToString("\n")}")
    close()
}

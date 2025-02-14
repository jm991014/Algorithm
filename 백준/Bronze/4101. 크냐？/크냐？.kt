private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    while(true) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        if (a == 0) break
        write(if (a > b) "Yes\n" else "No\n")
    }
    close()
}
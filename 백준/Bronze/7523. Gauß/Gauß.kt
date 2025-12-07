private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        write("Scenario #${it + 1}:\n")
        val (s, e) = br.readLine().split(" ").map { it.toLong() }
        write("${(s + e) * (e - s + 1) / 2}\n\n")
    }
    close()
}
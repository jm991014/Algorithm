private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val team = Array(3) { br.readLine().split(" ") }
    bw.write("${team.sortedBy { it[1] }.map { it[1].toInt() % 100 }.joinToString("")}\n")
    bw.write(team.sortedByDescending { it[0].toInt() }.map { it[2][0] }.joinToString(""))
    bw.close()
}
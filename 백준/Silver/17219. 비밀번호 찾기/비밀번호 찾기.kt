private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var (N, M) = br.readLine().split(" ").map { it.toInt() }
    val password = HashMap<String, String>(N).apply {
        repeat(N) {  br.readLine().split(" ").let { put(it[0], it[1]) } }
    }
    val target = Array(M) { br.readLine() }
    target.forEach {
        write("${password[it]}\n")
    }
    close()
}
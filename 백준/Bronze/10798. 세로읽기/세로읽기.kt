private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val s = Array(5) { br.readLine() }
    var ans = ""
    for (i in 0 until 15) {
        for (string in s) {
            if (string.length > i) ans += string[i]
        }
    }
    write(ans)
    close()
}